package com.hx.sort;

import java.util.Arrays;

/**
 * @author jxlgcmh
 * @create 2019-06-23 20:22
 *
 * 归并排序：时间复杂度O(n log n)
 */
public class MergeSort {
	
	public static void main(String[] args) {
		int [] arr = {5,6,84,53,4,8,31,5};
		int [] temp = new int[arr.length];
		mergeSort(arr,0,arr.length-1,temp);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr, int left,int right, int[] temp) {
		
		
		
		if (left < right) {
			int mid =(left+right) / 2;
			//左递归分解
			mergeSort(arr,left,mid,temp);
			//有递归分解
			mergeSort(arr,mid+1,right,temp);
			
			//System.out.println(left+"\t"+right);
			
			merge(arr,left,mid,right,temp);
		}
	}
	
	
	
	
	
	
	
	/**
	 * @param arr
	 * @param left
	 * @param mid
	 * @param right
	 * @param temp  临时数组
	 */
	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		//初始化i表示左边初始化索引
		int i = left;
		//表示右边有序序列的初始索引
		int j = mid + 1;
		// 临时数组的索引
		int t = 0;
		
		//1、先把左右两边的数据按规则填充到temp数组，直到一边处理完毕
		while (i <= mid && j <= right) {
			//左边大于右边，左边拷到临时数组
			if (arr[i] <= arr[j]) {
				temp[t] = arr[i];
				//临时数组指针后移
				t++;
				//后移
				i++;
			}
			//左边小于右边，右边边拷到临时数组
			else {
				temp[t] = arr[j];
				//临时数组指针后移
				t++;
				//后移
				j++;
			}
		}
		
		//2、将剩余一边的数组拷贝到temp
		//2.1、拷贝左边剩余
		while (i <= mid) {
			temp[t] = arr[i];
			//临时数组指针后移
			t++;
			//后移
			i++;
		}
		while (j <= right) {
			temp[t] = arr[j];
			//临时数组指针后移
			t++;
			//后移
			j++;
		}
		
		//3、将temp拷贝回原来的数组
		//3.1、总共会有7次的拷贝
		
		t =0;
		int tempLeft = left;
		System.out.println(tempLeft+"\t"+right);
		while (tempLeft <= right) {
			arr[tempLeft] = temp[t];
			t++;
			tempLeft++;
		}
		
	}
}
