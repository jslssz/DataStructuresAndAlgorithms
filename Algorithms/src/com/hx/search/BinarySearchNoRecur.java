package com.hx.search;

/**
 * 二分查找非递归实现
 *
 * @author jxlgcmh
 * @date 2019-08-10 09:39
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 9};
        int result = binarySearchNoRecur(arr, 9);
        System.out.println(result);
    }

    private static int binarySearchNoRecur(int[] arr, int target) {
        int left =0;
        int right =arr.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (arr[mid] == target) {
                return mid;
            }
            // 中间值比目标值更大,往右移动
            else if (arr[mid] > target) {
                right = mid-1;
            }
            else {
                left =mid+1;
            }

        }
        return -1;
    }
}
