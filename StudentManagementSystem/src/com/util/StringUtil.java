package com.util;
/**
 *类名： StringUtil.java
 *作者： 19241045王彪
 *描述： 判断文本框是否为空
 *时间:  2021/12/16 1:16
 *版本:  1.8
 */
public class StringUtil {
    public static boolean isEmpty(String str) {
        if ("".equals(str)||str == null){
         return true;
        }
        return false;
    }
}
