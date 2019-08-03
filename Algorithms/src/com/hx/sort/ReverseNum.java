package com.hx.sort;

/**
 * @author jxlgcmh
 * @create 2019-06-20 14:09
 */
public class ReverseNum {
	public static void main(String[] args) {
		
		
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
