package com.example.paydemo.jd.util;

/**
 * @Package: com.jd.jr.aggre.api.export.security
 * @Create at: 2018/3/2 17:32
 * @author: liuhj Modification History: Date Author Version Description
 *          -----------------------------------------------------------------
 *          2018/3/2 liuhj 1.0 1.0 Version
 */
public abstract class StringUtils {

    public static final String EMPTY = "";

    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }

    public static boolean hasText(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        }
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }
    public static boolean hasText(String str) {
        return hasText((CharSequence) str);
    }

    public static String trimToEmpty(String str) {
        return str == null ? EMPTY : str.trim();
    }
}
