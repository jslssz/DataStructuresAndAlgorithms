package com.hx.sort;

import java.util.Arrays;

/**
 * @author jxlgcmh
 * @create 2019-06-22 11:07
 *
 * 插入排序,时间复杂度O(n^2)
 *
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] arr = {9, 8, 6, 7, 3, 4,2,5};
		//总共length-1 轮
		for (int i = 1; i < arr.length; i++) {
			//暂存要插入的值
			int insertVal = arr[i];
			//记录想要插入的下标
			int insertIndex = i - 1;
			while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
				//交换值
				arr[insertIndex + 1] = arr[insertIndex];
				//下标往前移
				insertIndex--;
			}
			//赋值给插入位置
			arr[insertIndex + 1] = insertVal;
			//打印每次交换的结果
			System.out.println(Arrays.toString(arr));
		}
	}
}
