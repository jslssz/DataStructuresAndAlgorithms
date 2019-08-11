package com.hx.match;

/**
 * 暴力匹配
 * @author jxlgcmh
 * @date 2019-08-11 08:28
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String s1 = "abfsdknfnsk";
        String s2 ="dkn";
        int result = violenceMatch(s1, s2);
        System.out.println(result);
    }

    private static int violenceMatch(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        // s1 的光标
        int i =0;
        // s2 的光标
        int j =0;
        // j < len2是主要退出条件,一旦匹配就会超过长度
        while (i < len1 && j < len2) {
            /// 匹配
            if (chars1[i] == chars2[j]) {
                i++;
                j++;
            }
            // 没有匹配,重置游标
            else {
                i = i -(j-1);
                j= 0;
            }
        }
        if (j == len2) {
            return i-j;
        }else {
            return -1;
        }
    }
}
