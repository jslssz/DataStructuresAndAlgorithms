package com.hx.sort;

/**
 * @author jxlgcmh
 * @create 2019-06-11 17:21
 */
public class BuboSort {
	
	public static void main(String[] args) {
		int  []  arr ={2,3,7,5,6,8};
//		for (int i=0;i<arr.length-1;i++){
//			for (int j = i + 1; j < arr.length; j++) {
//				if (arr[i]<arr[j]){
//					int temp =arr[i];
//					arr[i] =arr[j];
//					arr[j]=temp;
//				}
//			}
//		}
//		for (int i = 0; i < arr.length - 1; i++) {
//			for (int j = 0; j < arr.length - i - 1; j++) {
//				if (arr[j] > arr[j + 1]) {
//					int temp =arr[j];
//					arr[j]=arr[j+1];
//					arr[j+1]=temp;
//				}
//			}
//		}
//
//		for (int i : arr) {
//			System.out.print(i+" ");
//		}
		
		int a=895151;
		int rs = 0;
		while (a > 0) {
			rs *= 10;
			rs += a % 10;
			a /= 10;
		}
		System.out.println(rs);
		
	}
}
