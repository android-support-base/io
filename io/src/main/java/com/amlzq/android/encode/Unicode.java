package com.amlzq.android.encode;

/**
 * 中文转Unicode 以及 Unicode转中文
 * https://www.cnblogs.com/austinspark-jessylu/p/6873198.html
 * 在 windows 和 linux 中运行结果不一致。
 */

public class Unicode {

    public static String encode(String input) {
//        chinese = (chinese == null ? "" : chinese);
//        String tmp;
//        StringBuffer sb = new StringBuffer(1000);
//        char c;
//        int i, j;
//        sb.setLength(0);
//        for (i = 0; i < chinese.length(); i++) {
//            c = chinese.charAt(i);
//            sb.append("\\u");
//            j = (c >>> 8); //取出高8位
//            tmp = Integer.toHexString(j);
//            if (tmp.length() == 1)
//                sb.append("0");
//            sb.append(tmp);
//            j = (c & 0xFF); //取出低8位
//            tmp = Integer.toHexString(j);
//            if (tmp.length() == 1)
//                sb.append("0");
//            sb.append(tmp);
//        }
//        return (new String(sb));

        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append("\\u").append(Integer.toString(aChar, 16));
        }
        return sb.toString();
    }

    public static String utf8ToUnicode(String input) {
        char[] myBuffer = input.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            Character.UnicodeBlock ub = Character.UnicodeBlock.of(myBuffer[i]);
            if (ub == Character.UnicodeBlock.BASIC_LATIN) {
                //英文及数字等
                sb.append(myBuffer[i]);
            } else if (ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                //全角半角字符
                int j = (int) myBuffer[i] - 65248;
                sb.append((char) j);
            } else {
                //汉字
                short s = (short) myBuffer[i];
                String hexS = Integer.toHexString(s);
                String unicode = "\\u" + hexS;
                sb.append(unicode.toLowerCase());
            }
        }
        return sb.toString();
    }

    /**
     * 以 \ u 分割，因为java注释也能识别unicode，因此中间加了一个空格
     */
    public static String decode(String unicode) {
        String[] strings = unicode.split("\\\\u");
        StringBuilder sb = new StringBuilder();
        // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
        for (String aString : strings) {
            sb.append((char) Integer.valueOf(aString, 16).intValue());
        }
        return sb.toString();
    }

}