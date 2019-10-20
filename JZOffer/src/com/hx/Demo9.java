package com.hx;


/**
 * 最小旋转数
 *
 * @author jxlgcmh
 * @date 2019-10-20 15:23
 */
public class Demo9 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(arr));
    }

    public static int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            // 如果中间的数大于最右边的数，则下标r =m;
            if (nums[m] < nums[r]) {
                r = m;
            }
            // 如果中间的数小于等于最右边的数  l=m+1；
            else {
                l = m + 1;
            }
        }
        // 如果r>=l;则返回
        return nums[l];
    }
}
