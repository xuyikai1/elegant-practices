package org.elegant.practice.pay.jd.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elegant.practice.pay.jd.util.vo.DecryptAndVerifyReqBean;
import org.elegant.practice.pay.jd.util.vo.DecryptAndVerifyResBean;
import org.elegant.practice.pay.jd.util.vo.EncryptAndSignReqBean;
import org.elegant.practice.pay.jd.util.vo.EncryptAndSignResBean;

import java.util.Map;
import java.util.TreeMap;


/**
 * 支付前端安全加密解密工具类
 */
public class SecurityUtils {

    private static Log logger = LogFactory.getLog(SecurityUtils.class);

    /**
     * @Title: decryptAndVerifyAndURLDecoder 与encryptAndSignAndURLEncoder方法成对使用
     * @Description: 解密且验签,将通过URLDecoder解码签名以及加密数据,并做验签操作,
     *               验签时:需要对解密后的明文json数据asii码排序,并通过&连接,然后再进行验签操作
     */
    public static DecryptAndVerifyResBean decryptAndVerifyAndURLDecoder(DecryptAndVerifyReqBean decryptAndVerifyReqBean) {
        DecryptAndVerifyResBean decryptAndVerifyResBean = new DecryptAndVerifyResBean();
        if (null == decryptAndVerifyReqBean || !StringUtils.hasText(decryptAndVerifyReqBean.getMd5SaltKey())
                || !StringUtils.hasText(decryptAndVerifyReqBean.getTripleDESKey()) || !StringUtils.hasText(decryptAndVerifyReqBean.getSign())
                || !StringUtils.hasText(decryptAndVerifyReqBean.getEncrypt())) {
            decryptAndVerifyResBean.setSuccess(false);
            if (null == decryptAndVerifyReqBean) {
                decryptAndVerifyResBean.setDesc(SECURITYERRORMES.EMPTY_PARAM.getMessage());
            } else if (!StringUtils.hasText(decryptAndVerifyReqBean.getMd5SaltKey())) {
                decryptAndVerifyResBean.setDesc(SECURITYERRORMES.SALT_NULL.getMessage());
            } else if (!StringUtils.hasText(decryptAndVerifyReqBean.getTripleDESKey())) {
                decryptAndVerifyResBean.setDesc(SECURITYERRORMES.CIPHERKEY_NULL.getMessage());
            } else if (!StringUtils.hasText(decryptAndVerifyReqBean.getEncrypt())) {
                decryptAndVerifyResBean.setDesc(SECURITYERRORMES.CIPHERTEXT_NULL.getMessage());
            } else {
                decryptAndVerifyResBean.setDesc(SECURITYERRORMES.SIGN_NULL.getMessage());
            }
            return decryptAndVerifyResBean;
        }
        String key = decryptAndVerifyReqBean.getTripleDESKey();
        String salt = decryptAndVerifyReqBean.getMd5SaltKey();
        String sign = decryptAndVerifyReqBean.getSign();
        String cipher = decryptAndVerifyReqBean.getEncrypt();
        /**
         * 解密
         */
        try {
            // cipher = URLDecoder.decode(cipher, "UTF-8");
            String decryptText = TripleDES.decrypt(cipher, key, "UTF-8");
            decryptAndVerifyResBean.setPlain(decryptText);
        } catch (Throwable e) {
            logger.error("密文数据=" + cipher + ",解密失败,异常信息:" + e);
            decryptAndVerifyResBean.setSuccess(false);
            decryptAndVerifyResBean.setDesc(SECURITYERRORMES.DECRYPT_FAIL.getMessage());
            return decryptAndVerifyResBean;
        }
        /**
         * 验签
         */
        try {
            // asii排序后的字符串
            String decryptAsiiText = genQueryStringByJsonAsii(decryptAndVerifyResBean.getPlain());
            // sign = URLDecoder.decode(sign, "UTF-8");
            boolean verify = MD5.verify(decryptAsiiText, salt, sign);
            decryptAndVerifyResBean.setVerify(verify);
            // 如果验签失败直接返回false
            if (false == verify) {
                decryptAndVerifyResBean.setSuccess(verify);
            }
        } catch (Exception e) {
            logger.error("签名数据=" + sign + ",验签失败,异常信息:", e);
            decryptAndVerifyResBean.setSuccess(false);
            decryptAndVerifyResBean.setDesc(SECURITYERRORMES.VERIFY_FAIL.getMessage());
            return decryptAndVerifyResBean;
        }
        return decryptAndVerifyResBean;
    }

    /*
     * @Title: encryptAndSignAndURLEncoder与 decryptAndVerifyAndURLDecoder成对使用
     * @Description:加密并加签,并对加密签名数据分别做URLEncoder转码
     * 将请求map中text为json格式的数据,做加密并做URLEncoder.encode
     * 操作,并将json格式数据key按照asii码顺序做排列,然后加签并做URLEncoder.encode操作
     */
    public static EncryptAndSignResBean encryptAndSignAndURLEncoder(EncryptAndSignReqBean encryptAndSignReqBean) {
        EncryptAndSignResBean encryptAndSignResBean = new EncryptAndSignResBean();
        if (null == encryptAndSignReqBean || !StringUtils.hasText(encryptAndSignReqBean.getMd5SaltKey())
                || !StringUtils.hasText(encryptAndSignReqBean.getTripleDESKey()) || !StringUtils.hasText(encryptAndSignReqBean.getPlain())) {
            encryptAndSignResBean.setSuccess(false);
            if (null == encryptAndSignReqBean) {
                encryptAndSignResBean.setDesc(SECURITYERRORMES.EMPTY_PARAM.getMessage());
            } else if (!StringUtils.hasText(encryptAndSignReqBean.getMd5SaltKey())) {
                encryptAndSignResBean.setDesc(SECURITYERRORMES.SALT_NULL.getMessage());
            } else if (!StringUtils.hasText(encryptAndSignReqBean.getTripleDESKey())) {
                encryptAndSignResBean.setDesc(SECURITYERRORMES.CIPHERKEY_NULL.getMessage());
            } else {
                encryptAndSignResBean.setDesc(SECURITYERRORMES.PLAIN_NULL.getMessage());
            }
            return encryptAndSignResBean;
        }
        String key = encryptAndSignReqBean.getTripleDESKey();
        String text = encryptAndSignReqBean.getPlain();
        String salt = encryptAndSignReqBean.getMd5SaltKey();

        try {
            /**
             * 加密
             */
            String encryptText = TripleDES.encrypt(text, key, "UTF-8");
            // encryptText = URLEncoder.encode(encryptText, "UTF-8");
            encryptAndSignResBean.setEncrypt(encryptText);
        } catch (Throwable e) {
            logger.error("明文数据=" + text + ",加密失败,异常信息:", e);
            encryptAndSignResBean.setSuccess(false);
            encryptAndSignResBean.setDesc(SECURITYERRORMES.DECRYPT_FAIL.getMessage());
            return encryptAndSignResBean;
        }
        /**
         * 验签
         */
        try {
            // json格式的text做asii码排序,然后通过&做拼接
            String strSignText = genQueryStringByJsonAsii(text);
            String sign = MD5.md5(strSignText, salt);
            // sign = URLEncoder.encode(sign, "UTF-8");
            encryptAndSignResBean.setSign(sign);
        } catch (Exception e) {
            logger.error("明文数据=" + text + ",加签失败,异常信息:", e);
            encryptAndSignResBean.setSuccess(false);
            encryptAndSignResBean.setDesc(SECURITYERRORMES.SIGN_FAIL.getMessage());
            return encryptAndSignResBean;
        }
        return encryptAndSignResBean;
    }

    /**
     * 将json格式的字符串按照asii码排序,然后通过&拼接为字符串,类似:amount=1&merchantId=434343
     *
     * @param jsonStr
     * @return
     * @throws Exception
     */
    public static String genQueryStringByJsonAsii(String jsonStr) throws Exception {

        TreeMap<String, Object> requestStrTreeMap = JSON.parseObject(jsonStr, TreeMap.class);

        return genQueryString(requestStrTreeMap);
    }

    /**
     * 将按照asii码排序的map做字符串拼接
     *
     * @param messageMap
     * @return
     * @throws Exception
     */
    @SuppressWarnings("null")
    private static String genQueryString(TreeMap<String, Object> messageMap) throws Exception {
        if (null == messageMap && messageMap.size() == 0) {
            throw new Exception("messageMap数据为null,不能进行拼接生成字符串");
        }
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        int length = messageMap.size();
        for (Map.Entry<String, Object> entry : messageMap.entrySet()) {
            if (addQueryString(stringBuilder, entry.getKey(), String.valueOf(entry.getValue()))) {
                if (index != length - 1) {
                    stringBuilder.append("&");
                }
            }
            ++index;
        }
        return stringBuilder.toString();
    }

    private static boolean addQueryString(StringBuilder stringBuilder, String key, String value) {
        if (stringBuilder == null || !StringUtils.hasText(key) || !StringUtils.hasText(value)) {
            return false;
        }
        stringBuilder.append(key);
        stringBuilder.append("=");
        stringBuilder.append(value);
        return true;
    }

    public enum SECURITYERRORMES {

        SIGN_FAIL("签名失败"), VERIFY_FAIL("验签失败"), SIGN_NULL("签名为空"), SALT_NULL("MD5盐值为空"), EMPTY_PARAM("空的参数"), CIPHERTEXT_NULL("空的加密信息"), CIPHERKEY_NULL(
                "3des密钥为空"), PLAIN_NULL("明文数据为空"), DECRYPT_FAIL("解密失败"), DECRYPT_EMPTY("解密后为空");

        private String message;

        /**
         * @Title:SECURITYERRORMES
         * @Description:TODO
         * @param message
         */
        private SECURITYERRORMES(String message) {
            this.message = message;
        }

        /**
         * @return the message
         */
        public String getMessage() {
            return message;
        }

        /**
         * @param message
         *            the message to set
         */
        public void setMessage(String message) {
            this.message = message;
        }

    }

}
