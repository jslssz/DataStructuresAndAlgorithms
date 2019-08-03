package com.hx.sort;

import java.util.Arrays;

/**
 * @author jxlgcmh
 * @create 2019-06-24 20:25
 */
public class RadixSort {
	public static void main(String[] args) {
		int [] arr = {53, 3, 542, 748, 14, 214};
		radixSort2(arr);
	}
	
	public static void radixSort2(int[] arr) {
		
		//0、得到数组中最长的元素，从而获取长度，进而判断循环次数
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (temp < arr[i]) {
				temp =arr[i];
			}
		}
		//最长的元素
		int len = temp + "".length();
		
		
		
		//定义一个二维数组
		//1、10表示有10个桶，即代表每位数0,1,2，3,4,5,6,7,8,9
		//后面则表示桶的最大容量，里面有多少个元素
		int[][] bucket = new int[10][arr.length];
		//统计每个桶有多少个元素
		int[] bucketElementCounts = new int[10];
		
		for (int z = 0; z < len; z++) {
			//第一轮：对每个元素按个位装入桶中
			for (int i = 0; i < arr.length; i++) {
				//依次取得元素的个位数,即对应的桶
				int digitOfElement = (int) (arr[i] / Math.pow(10,z) % 10);
				//将元素放入对应的桶中 //bucketElementCounts[digitOfElement]
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
				//要++,后移
				bucketElementCounts[digitOfElement]++;
			}
			//重新放回原来的数组
			int index = 0;
			//将每个桶中的元素放回原来数组中
			for (int k = 0; k < bucketElementCounts.length; k++) {
				//不等于0，代表桶中有元素
				if (bucketElementCounts[k] != 0) {
					for (int l = 0; l < bucketElementCounts[k]; l++) {
						arr[index++] = bucket[k][l];
					}
				}
				//重新置零
				bucketElementCounts[k] = 0;
			}
		}
		
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	
	
	
	
	
	
	
	public static void radixSort(int[] arr) {
		//定义一个二维数组
		//1、10表示有10个桶，即代表每位数0,1,2，3,4,5,6,7,8,9
		//后面则表示桶的最大容量，里面有多少个元素
		int[][] bucket = new int[10][arr.length];
		//统计每个桶有多少个元素
		int[] bucketElementCounts = new int[10];
		
		//第一轮：对每个元素按个位装入桶中
		for (int i = 0; i < arr.length; i++) {
			//依次取得元素的个位数,即对应的桶
			int digitOfElement = arr[i] / 1 % 10;
			//将元素放入对应的桶中 //bucketElementCounts[digitOfElement]
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
			//要++,后移
			bucketElementCounts[digitOfElement]++;
		}
		//重新放回原来的数组
		int index = 0;
		//将每个桶中的元素放回原来数组中
		for (int k = 0; k < bucketElementCounts.length; k++) {
			//不等于0，代表桶中有元素
			if (bucketElementCounts[k] != 0) {
				for (int l = 0; l < bucketElementCounts[k]; l++) {
					arr[index++] = bucket[k][l];
				}
			}
			//重新置零
			bucketElementCounts[k] = 0;
		}
		System.out.println(Arrays.toString(arr));
		
		for (int i = 0; i < arr.length; i++) {
			//依次取得元素的个位数,即对应的桶
			int digitOfElement = arr[i] / 1 / 10 % 10;
			//将元素放入对应的桶中 //bucketElementCounts[digitOfElement]
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
			//要++,后移
			bucketElementCounts[digitOfElement]++;
		}
		//重新放回原来的数组
		 index = 0;
		//将每个桶中的元素放回原来数组中
		for (int k = 0; k < bucketElementCounts.length; k++) {
			//不等于0，代表桶中有元素
			if (bucketElementCounts[k] != 0) {
				for (int l = 0; l < bucketElementCounts[k]; l++) {
					arr[index++] = bucket[k][l];
				}
			}
			//重新置零
			bucketElementCounts[k] = 0;
		}
		System.out.println(Arrays.toString(arr));
		
		for (int i = 0; i < arr.length; i++) {
			//依次取得元素的个位数,即对应的桶
			int digitOfElement = arr[i] / 1 /10 / 10 % 10;
			//将元素放入对应的桶中 //bucketElementCounts[digitOfElement]
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
			//要++,后移
			bucketElementCounts[digitOfElement]++;
		}
		//重新放回原来的数组
		 index = 0;
		//将每个桶中的元素放回原来数组中
		for (int k = 0; k < bucketElementCounts.length; k++) {
			//不等于0，代表桶中有元素
			if (bucketElementCounts[k] != 0) {
				for (int l = 0; l < bucketElementCounts[k]; l++) {
					arr[index++] = bucket[k][l];
				}
			}
			//重新置零
			bucketElementCounts[k] = 0;
		}
		System.out.println(Arrays.toString(arr));
		
	}
}
