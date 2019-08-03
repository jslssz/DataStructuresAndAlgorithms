package com.hx.sort;

import java.util.Arrays;

/**
 * 堆排序，时间复杂度O(nlogn)
 *
 * @author jxlgcmh
 * @date 2019-08-03 10:39
 */
public class HeadSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        headSort(arr);
    }

    public static void headSort(int[] arr) {
        int temp = 0;
        System.out.println("堆排序：");
/*        adjustHeap(arr,1,arr.length);
        System.out.println("第一次："+ Arrays.toString(arr));
        adjustHeap(arr,0,arr.length);
        System.out.println("第二次："+ Arrays.toString(arr));*/
        /**
         * 通过观察,构建成堆，i表示非叶子节点的下标
         */
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }

        /**
         * 将堆顶元素与末尾元素交换
         */
        for (int j = arr.length - 1; j > 0; j--) {
            temp =arr[j];
            arr[j] = arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);
        }
        System.out.println("从小到大最终排序结果："+Arrays.toString(arr));
    }

    /**
     * 调整为大堆项
     *
     * @param arr
     * @param i  非叶子节点在数组中的索引
     * @param length 表示有多少个元素继续调整
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        //取出当前元素的值，保存在零时变量中
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 左子节点的值小于右子节点的值
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                // 指向右子节点
                k++;
            }
            // 如果子节点大于父节点
            if (arr[k] > temp) {
                // 交换
                arr[i] = arr[k];
                // i指向k，继续循环比较
                i=k;
            }else {
                break;
            }
        }
        arr[i]=temp;
    }
}
