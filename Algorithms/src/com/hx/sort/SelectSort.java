package com.hx.sort;

import java.util.Arrays;

/**
 * @author jxlgcmh
 * @create 2019-06-20 16:11
 * <p>
 * 选择排序，时间复杂度O(n^2)
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 5, 6, 8};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
