package com.hx.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jxlgcmh
 * @create 2019-07-02 13:04
 */
public class BinarySearch {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 7,7,7, 9};
		//int res = binarySearch(arr, 0, arr.length - 1, 10);
		//System.out.println(res);
		
		List<Integer> res = binarySearch2(arr, 0, arr.length - 1, 7);
		System.out.println(res);
		
	}
	
	
	/**
	 * 二分查找,前提，数组有序，此时，返回多个下标
	 *
	 * @param arr
	 * @param left
	 * @param right
	 * @param target
	 * @return
	 */
	public static List<Integer> binarySearch2(int[] arr, int left, int right, int target) {
		
		int mid = (left + right) / 2;
		
		if (left > right) {
			return new ArrayList<Integer>();
		}
		// 中间值更大，则往左找
		if (arr[mid] > target) {
			return binarySearch2(arr, left, mid - 1, target);
		}
		// 中间值更小，则往右找
		else if (arr[mid] < target) {
			return binarySearch2(arr, mid + 1, right, target);
		}
		//此时，因为数组是有序的，找目标值后进行左右判断
		else {
			
			List<Integer> list = new ArrayList<Integer>();
			
			//临时索引
			int tempIndex = mid - 1;
			
			//先往作为判断
			while (tempIndex >= 0 && target == arr[tempIndex]) {
				list.add(tempIndex);
				tempIndex--;
			}
			
			//此时添加最先找到的目标索引
			list.add(mid);
			
			//往右为判断
			while (tempIndex < arr.length && target == arr[tempIndex]) {
				list.add(tempIndex);
				tempIndex++;
			}
			
			return list;
		}
	}
	
	
	/**
	 * 二分查找,前提，数组有序
	 *
	 * @param arr
	 * @param left
	 * @param right
	 * @param target
	 * @return
	 */
	public static int binarySearch(int[] arr, int left, int right, int target) {
		
		int mid = (left + right) / 2;
		
		if (left > right) {
			return -1;
		}
		// 中间值更大，则往左找
		if (arr[mid] > target) {
			return binarySearch(arr, left, mid - 1, target);
		}
		// 中间值更小，则往右找
		else if (arr[mid] < target) {
			return binarySearch(arr, mid + 1, right, target);
		} else {
			return mid;
		}
	}
}
