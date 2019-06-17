package com.hx.arr;

import java.util.Scanner;

/**
 * @author jxlgcmh
 * @create 2019-06-16 15:15
 */
public class SnakeArray {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int tempN = n;
		int[][] a = new int[n][n];
		int i, j, num = 0, nn = 1;
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				a[i][j] = 0;
			}
			System.out.println();
		}
		while (n > 0) {
			if (n == 1) {
				a[num][num] = nn;
			}
			a[num][num] = nn;
			if (n > 1) {
				a[num + 1][num] = 4 * n - 5 + a[num][num];
				//上边横着
				for (i = num, j = num + 1; j < num + n; j++) {
					a[i][j] = a[num][num] + j - num;
				}
				//右边竖着
				for (j = num + n - 1, i = num + 1; i < num + n; i++) {
					a[i][j] = a[i - 1][j] + 1;
					
				}
				//下面横着
				for (i = num + n - 1, j = n + num - 2; j >= num; j--) {
					a[i][j] = a[i][j + 1] + 1;
				}
				//左面竖着
				for (j = num, i = num + n - 2; i > num; i--) {
					a[i][j] = a[i + 1][j] + 1;
				}
			} else {
				break;
			}
			nn += 4 * n - 4;
			n = n - 2;
			num++;
		}
		for (i = 0; i < tempN; i++) {
			for (j = 0; j < tempN; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}
}