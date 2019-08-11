package com.hx.match;

import javax.print.DocFlavor;
import java.util.Arrays;

/**
 * kmp 算法
 *
 * @author jxlgcmh
 * @date 2019-08-11 15:04
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int[] kmpNext = kmpNext(str2);
        System.out.println(Arrays.toString(kmpNext));
        int result = kmpSearch(str1, str2, kmpNext);
        System.out.println(result);
    }

    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j=next[j-1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i-j+1;
            }
        }
        return -1;
    }

    /**
     * 获取一个字符串的部分匹配表
     *
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0]=0;
        for (int i = 1,j=0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j=next[j-1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] =j;
        }
        return next;
    }
}
