package com.hx.ai;

/**
 * 查找1-n  中1出现的个数
 *
 * @author jxlgcmh
 * @date 2019-08-13 15:43
 */
public class FindOneAppear {
    public static void main(String[] args) {
        System.out.println(findOne(11));
    }

    public static int findOne(int n) {
        if (n < 0) {
            return -1;
        }
        //统计0出现的计数器
        int sum =0;
        for (int i = 1; i <= n; i++) {
            // 用temp 来暂存 i;
            int temp =i;
            while (temp > 0) {
                if (i % 10 == 1) {
                    sum++;
                }
                temp /= 10;
            }
        }
        return sum;
    }
}
