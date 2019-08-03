package com.hx.search;

/**
 * 插值查找算,这个算法主要是对二分查找的优化，适合粒度比较细的数组
 * <p>
 * 二分查找是
 *
 * @author jxlgcmh
 * @create 2019-07-06 09:34
 */
public class InsertValueSearch {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 7, 9};
		int res = insertValueSearch(arr, 0, arr.length - 1, 1);
		System.out.println(res);
	}
	
	/**
	 *
	 * @param arr
	 * @param left
	 * @param right
	 * @param target
	 * @return
	 */
	public static int insertValueSearch(int[] arr, int left, int right, int target) {
		//测试要查找多少次
		System.out.println("hello");
		// 判断退出的条件
		if (left > right || target < arr[0] || target > arr[arr.length -1]) {
			return -1;
		}
		//中值的条件的改变
		int mid = left + (right-left) * (target-arr[left])/(arr[right]-arr[left]);
		
		// 中间值更大，则往左找
		if (arr[mid] > target) {
			return insertValueSearch(arr, left, mid - 1, target);
		}
		// 中间值更小，则往右找
		else if (arr[mid] < target) {
			return insertValueSearch(arr, mid + 1, right, target);
		} else {
			return mid;
		}
	}
}
