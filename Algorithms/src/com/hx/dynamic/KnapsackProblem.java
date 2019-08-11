package com.hx.dynamic;

/**
 * 动态规划算法
 * 背包问题
 * 限定重量并且价值最大
 *
 * @author jxlgcmh
 * @date 2019-08-11 13:32
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        // 物品的重量,每个值表示重多少磅
        int[] w = {1, 4, 3};
        // 物品的价值
        int[] val = {1500, 3000, 2000};
        // 背包的容量,表示最大容量为4磅
        int m = 4;
        // 物品的个数
        int n = val.length;
        /**
         * int[i][j] v  表示前i个物品中能够装入容量为j的背包中的最大价值
         */
        int[][] v = new int[n + 1][m + 1];
        /**
         * 记录商品的放入情况
         */
        int[][] path = new int[n + 1][m + 1];
        // 每行的第一列置为0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        // 每列的第1行置为0
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }
        // 处理完毕后进行动态规划处理
        // 相当于二维数组的遍历
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    if (v[i - 1][j] < (val[i - 1] + v[i - 1][j - w[i - 1]])) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j]+"\t");
            }
            System.out.println();
        }

        int i =path.length-1;
        int j =path[0].length-1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入背包\n",i);
                j-=w[i-1];
            }
            i--;
        }

    }
}
