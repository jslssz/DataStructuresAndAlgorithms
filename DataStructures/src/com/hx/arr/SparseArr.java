package com.hx.arr;

import java.io.*;

/**
 * 稀疏数组
 *
 * @author jxlgcmh
 * @create 2019-06-01 18:57
 */
public class SparseArr {
	public static void main(String[] args) {
		//1、初始化数组
		System.out.println("初始化数组：");
		int[][] arr = new int[11][11];
		arr[1][2] = 1;
		arr[2][3] = 2;
		arr[2][8] = 2;
		arr[10][10] = 2;
		for (int[] row : arr) {
			for (int item : row) {
				System.out.printf("%d\t", item);
			}
			System.out.println();
		}
		
		//2、转成稀疏数组
		//2.1 用来记录有多少个非零数
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 0) {
					count++;
				}
			}
		}
		//2.2初始化稀疏数组
		int[][] sparseArr = new int[count + 1][3];
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = count;
		//2.3 填充后面数据
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 0) {
					total++;
					sparseArr[total][0] = i;
					sparseArr[total][1] = j;
					sparseArr[total][2] = arr[i][j];
				}
			}
			
		}
		
		//3、存盘map.data
		File resource = saveMap(sparseArr);
		
		//4.读盘，恢复
		readMap(resource);
	}
	
	private static void readMap(File resource) {
		try {
			BufferedReader reader= new BufferedReader(new FileReader(resource));
			String line = reader.readLine();
			String[] splits = line.split(" ");
			int[][] recoverArr =new int[Integer.parseInt(splits[0])][Integer.parseInt(splits[1])];
			int record = Integer.parseInt(splits[2]);
			for (int i = 0; i < record; i++) {
				String recordLine = reader.readLine();
				String[] recordSplits = recordLine.split(" ");
				int row = Integer.parseInt(recordSplits[0]);
				int column = Integer.parseInt(recordSplits[1]);
				int value = Integer.parseInt(recordSplits[2]);
				recoverArr[row][column]=value;
			}
			System.out.println("恢复后数组:");
			for (int[] row : recoverArr) {
				for (int item : row) {
					System.out.printf("%d\t", item);
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static File saveMap(int[][] sparseArr) {
		File resource = new File("D:/map.data");
		FileOutputStream outputStream = null;
		if (resource.exists()) {
			try {
				resource.deleteOnExit();
				resource.createNewFile();
				outputStream = new FileOutputStream(resource);
				StringBuilder builder =new StringBuilder();
				for (int i = 0; i < sparseArr.length; i++) {
					for (int j = 0; j < sparseArr[i].length; j++) {
						builder.append(sparseArr[i][j]+" ");
					}
					builder.append("\n");
				}
				byte[] bytes = builder.toString().getBytes();
				outputStream.write(bytes);
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if (outputStream != null) {
					try {
						outputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return resource;
	}
}
