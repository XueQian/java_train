package com.tw.core.util;

import java.security.MessageDigest;

/**
 * Created by qxue on 7/13/15.
 */
public class MD5Util {
    public static String getMD5(String string) throws Exception {

        MessageDigest md5 = MessageDigest.getInstance("md5");
        byte[] cipherData = md5.digest(string.getBytes());
        StringBuilder builder = new StringBuilder();

        for (byte cipher : cipherData) {
            String toHexStr = Integer.toHexString(cipher & 0xff);
            builder.append(toHexStr.length() == 1 ? "0" + toHexStr : toHexStr);
        }
        return builder.toString();
    }
}
