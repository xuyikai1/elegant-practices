package org.elegant.practice;

import cn.hutool.core.util.RandomUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;

/**
 * @Author: Xuyk
 * @Description: 授权访问：https://help.aliyun.com/document_detail/32016.html
 * @Date: 2020/11/10
 */
@Slf4j
@Component
public class OssClient {

    /**
     * 上传图片
     * @param bytes 字节数组
     */
    public void uploadPicture(byte[] bytes){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
        String accessKeyId = "";
        String accessKeySecret = "";
        String bucketName = "xuyk-picture-bed";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId,accessKeySecret);

        String picName = RandomUtil.randomString(8);

        ossClient.putObject("xuyk-picture-bed",
                picName,
                new ByteArrayInputStream(bytes));
        log.info("【上传结果】:{}", picName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

}
