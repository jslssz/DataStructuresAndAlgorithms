package com.hx.sort;

import java.util.Arrays;

/**
 * 快排--分治算法
 *
 * @author jxlgcmh
 * @create 2019-06-23 16:30
 *
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 88, 88};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        int lIndex = left;
        int rIndex = right;
        //临时变量
        int temp;
        //中间那个值
        int pivot = arr[(left + right) / 2];
        //这个while循环左右划分
        while (lIndex < rIndex) {
            //左边找到大于pivot的值
            while (arr[lIndex] < pivot) {
                lIndex++;
            }
            //右边找小于pivot的值
            while (arr[rIndex] > pivot) {
                rIndex--;
            }
            //此时满足时退出while循环
            if (lIndex >= rIndex) {
                break;
            }
            //交换值
            temp = arr[lIndex];
            arr[lIndex] = arr[rIndex];
            arr[rIndex] = temp;
            //交换后的处理
            //如果此时左指针的值得中间值
            if (arr[lIndex] == pivot) {
                //右指针往前移
                rIndex--;
            }
            //如果此时右指针的值等于中间值
            if (arr[rIndex] == pivot) {
                //左指针往后移
                lIndex++;
            }
        }
        //递归
        //处理栈溢出问题
        if (lIndex == rIndex) {
            lIndex++;
            rIndex--;
        }
        //左递归,将左侧变为有序
        if (left < rIndex) {
            quickSort(arr, left, rIndex);
        }
        //右递归,将右侧变为有序
        if (right > lIndex) {
            quickSort(arr, lIndex, right);
        }
    }
}
