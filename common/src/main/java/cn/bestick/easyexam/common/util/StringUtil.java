package cn.bestick.easyexam.common.util;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 4/28/16
 * Time: 23:58
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class StringUtil {

    public static String format(String str, int length) {
        while (str.length() > length)
            length++;
        while (str.length() < length) {
            str = "0" + str;
        }
        return str;
    }

    public static String format(int num, int length) {
        String str = Integer.toHexString(num);
        return format(str, length);
    }
}
