package com.hx;

/**
 * @author jxlgcmh
 * @date 2019-08-11 16:32
 */
public class Demo1 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        int[] duplication = new int[arr.length];
        boolean result = duplicate(arr, arr.length, duplication);
        System.out.println(result);
    }

    public static boolean duplicate(int[] nums, int len, int[] duplication) {
        if (nums == null || len <= 0) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            // 数组的某个值与下标不相等
            while (nums[i] != i) {
                // 如果下面的值相等
                if (nums[i] == nums[nums[i]]) {
                    // 添加到重复数组中
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
