package com.hx.sort;

import java.util.Arrays;

/**
 * @author jxlgcmh
 * @create 2019-06-11 17:21
 *
 * 冒泡排序，时间复杂度O(n^2)
 *
 */
public class BuboSort {
	
	public static void main(String[] args) {
		int[] arr = {2, 1, 7, 5, 8, 9};
		boolean flag = false;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
				
			}
			System.out.println(Arrays.toString(arr));
			if (!flag) {
				break;
			} else {
				//flag置回false
				flag = false;
			}
			
		}
	}
}
