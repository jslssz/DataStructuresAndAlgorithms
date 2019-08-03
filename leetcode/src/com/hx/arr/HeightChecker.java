package com.hx.arr;

/**
 * @author jxlgcmh
 * @date 2019-07-28 21:57
 */
public class HeightChecker {

    public static void main(String[] args) {
        int [] arr ={1,1,4,2,1,3};
        int res = heightChecker(arr);
        System.out.println(res);
    }

    /**
     * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
     * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
     *
     * @param heights
     * @return
     */
    public static int heightChecker(int[] heights) {
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i){
                    count++;
                }
            }
        }
        return count;
    }
}
