package com.amlzq.android.encode;

import android.util.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by amlzq on 2018/11/26.
 * Base64编码
 * <p>
 * Base64是一种基于64个可打印字符来表示二进制数据的表示方法。
 * 通常用于处理文本数据的场合，表示、传输、存储一些二进制数据，包括MIME的电子邮件及XML的一些复杂数据。
 * </p>
 * <p>
 * https://zh.wikipedia.org/wiki/Base64
 * https://developer.android.com/reference/java/util/Base64
 * http://www.cnblogs.com/whoislcj/p/5887859.html
 * </p>
 * <p>
 * Flags参数
 * DEFAULT 这个参数是默认，使用默认的方法来加密
 * NO_PADDING 这个参数是略去加密字符串最后的”=”
 * NO_WRAP 这个参数意思是略去所有的换行符（设置后CRLF就没用了）
 * CRLF 这个参数看起来比较眼熟，它就是Win风格的换行符，意思就是使用CR LF这一对作为一行的结尾而不是Unix风格的LF
 * URL_SAFE 这个参数意思是加密时不使用对URL和文件名有特殊意义的字符来作为加密字符，具体就是以-和_取代+和/
 * </p>
 */

public class Base64Util {

    public static String encode(String inputMessage) {
        return encode(inputMessage.getBytes());
    }

    public static String decode(String inputMessage) {
        return new String(Base64.decode(inputMessage, Base64.DEFAULT));
    }

    public static String encode(byte[] input) {
        return Base64.encodeToString(input, Base64.DEFAULT);
    }

    public static String encode(File inputFile) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(inputFile);
            byte[] buffer = new byte[(int) inputFile.length()];
            fis.read(buffer);
            fis.close();
            return Base64.encodeToString(buffer, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decode(File inputFile) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(inputFile);
            byte[] buffer = new byte[(int) inputFile.length()];
            fos.write(buffer);
            fos.close();
            return new String(Base64.decode(buffer, Base64.DEFAULT));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}