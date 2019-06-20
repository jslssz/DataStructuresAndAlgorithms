package com.hx.recursive.hsp;

/**
 * @author jxlgcmh
 * @create 2019-06-19 16:21
 */
public class MiKong {
	public static void main(String[] args) {
		
		int[][] map = new int[7][8];
		//上下初始化为1
		for (int i = 0; i < 8; i++) {
			map[0][i] = 1;
			map[6][i] = 1;
		}
		//左右初始化为1
		for (int j = 1; j < 6; j++) {
			map[j][0] = 1;
			map[j][7] = 1;
		}
		//添加挡板
		map[2][1] = 1;
		map[2][2] = 1;
		//死胡同
		//map[1][2] = 1;
		
		setWay(map,1,1);
		
		
		for (int[] row : map) {
			for (int item : row) {
				System.out.print(item + "\t");
			}
			System.out.println();
		}
	}
	
	
	public static boolean setWay(int[][] map, int i, int j) {
		if (map[5][6] == 2) {
			return true;
		} else {
			if (map[i][j] == 0) {
				map[i][j] = 2;
				//策略：下右上左
				if (setWay(map, i + 1, j)) {
					return true;
				} else if (setWay(map, i, j + 1)) {
					return true;
				} else if (setWay(map, i - 1, j)) {
					return true;
				} else if (setWay(map, i, j - 1)) {
					return true;
				} else {
					map[i][j] = 3;
					return false;
				}
			} else {
				return false;
			}
		}
	}
}
