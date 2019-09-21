package com.hx;

/**
 * @author jxlgcmh
 * @date 2019-09-09 20:38
 */
public class Demo7 {
    public static void main(String[] args) {
        System.out.println(jump(5));
    }

    /**
     * 条台阶的方法
     *
     * @param n 表示有几级台阶
     * @return 返回有多少种跳法
     */
    public static int jump(int n) {
        if (n <= 2) {
            return n;
        }
        /**
         * 假设为两个台阶的情况下
         * 一次跳2格需要跳1次
         * 一次跳1格需要跳2次
         */
        int pre2 = 1;
        int pre1 = 2;
        int result = 1;
        for (int i = 2; i < n; i++) {
            result = pre2 + pre1;
            pre2=pre1;
            pre1 = result;
        }
        return result;

    }
}
