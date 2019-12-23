package com.hx.recursive;

/**
 * @author jxlgcmh
 * @create 2019-06-19 15:49
 */
public class RecursiveDemo {
	public static void main(String[] args) {
		test(4);
	}
	
	public static void test(int n) {
		if (n > 2) {
			test(n-1);
		}
		System.out.println(n);
		
	}
}
