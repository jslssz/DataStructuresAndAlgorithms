package com.hx;

import java.util.Arrays;

/**
 *  变态跳台阶，一次可以跳一阶，2阶，3阶，....，n阶。
 *  推导出公式：
 * @author jxlgcmh
 * @date 2019-10-20 15:23
 */
public class Demo8 {
    public static void main(String[] args) {
        System.out.println(jumpII(3));
    }

    public static int jumpII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp,1);
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] +=dp[j];            }
        }
        return  dp[target-1];
    }
}
