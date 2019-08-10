package com.hx.dac;

/**
 * 汉诺塔问题  通过队规实现,右分治思想
 * 直接看成只有两个盘
 * @author jxlgcmh
 * @date 2019-08-10 10:13
 */
public class HanoiTower {
    public static void main(String[] args) {
      move(3,'A','B','C');
    }

    /**
     * 汉诺塔移动方法
     * @param num 盘子的数量
     * @param a a柱
     * @param b b柱
     * @param c c柱
     */
    public static void move(int num, char a, char b, char c) {
        // 如果只有一个盘,直接移动到C柱
        if (num == 1) {
            System.out.println("第1个盘从"+a+"->"+c);
        }
        // 当盘的数量大于2
        else {
            // 先把最上面的盘从 A->B,移动过程会使用到C(先将1.....n-1号盘从A柱搬到B柱上)
            move(num-1,a,c,b);
            // 把最下边的盘从 A-> C(再将 n号盘移动到C柱)
            System.out.println("第"+num+"个盘从"+a +"->"+c);
            // 再从B->C,移动过程使用到A(再将1....n-1号盘搬到C柱上)
            move(num-1,b,a,c);
        }

    }
}
