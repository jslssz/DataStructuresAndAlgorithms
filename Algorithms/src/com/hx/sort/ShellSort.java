package com.hx.sort;

import java.util.Arrays;

/**
 * @author jxlgcmh
 * @create 2019-06-23 14:42
 * <p>
 * 解释distance的含义：也就是步长，e.g.  长度为10的数组，先分为按照2分的方式来划分
 * 先是 10/2 = 5,即5个一组，分为2组
 * 再是 5/2 = 2,即2个一组，分为5组
 * 再是 2/2 = 1,即1个一组，分为10组
 * 再是 1/2 = 0,排序完毕
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7,2,3,5,4,6,0};
        sortMethodI(arr);
        System.out.println(Arrays.toString(arr));
//        sortMethodII(arr);
//        System.out.println(Arrays.toString(arr));
		
		/*int len = arr.length;
		int temp;
		//第一步：分成len/2组 i=[5,6,7,8,9]
		for (int i = len / 2; i < len; i++) {
			for (int j = i - 5; j >= 0; j -= 5) {
				if (arr[j] > arr[j + 5]) {
					temp = arr[j];
					arr[j] = arr[j + 5];
					arr[j + 5] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		
		//第二步，分成len/2/2组 i=[2,3,4,5,....9]
		for (int i = len / 4; i < len; i++) {
			for (int j = i - 2; j >= 0; j -= 2) {
				if (arr[j] > arr[j + 2]) {
					temp = arr[j];
					arr[j] = arr[j + 2];
					arr[j + 2] = temp;
				}
				//System.out.println(Arrays.toString(arr));
			}
		}
		System.out.println(Arrays.toString(arr));
		
		//第三步，分成len/2/2/2组 i=[2,3,4,5,....9]
		for (int i = len / 6; i < len; i++) {
			for (int j = i - 1; j >= 0; j -= 1) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
				//System.out.println(Arrays.toString(arr));
			}
		}
		System.out.println(Arrays.toString(arr));
		*/
    }

    /**
     * 交换的方式
     *
     * @param arr
     */
    public static void sortMethodI(int[] arr) {
        int len = arr.length;
        int temp;
        for (int distance = len / 2; distance > 0; distance /= 2) {
            for (int i = distance; i < len; i++) {
                for (int j = i - distance; j >= 0; j -= distance) {
                    if (arr[j] > arr[j + distance]) {
                        temp = arr[j];
                        arr[j] = arr[j + distance];
                        arr[j + distance] = temp;
                    }
                }
            }
        }

    }

    /**
     * 位移的方式
     *
     * @param arr
     */
    public static void sortMethodII(int[] arr) {
        int len = arr.length;
        for (int distance = len / 2; distance > 0; distance /= 2) {
            for (int i = distance; i < len; i++) {
                //要插入的下标
                int insertIndex = i;
                //要插入的值
                int insertValue = arr[insertIndex];
                //若果成立，交换值
                while (insertIndex - distance >= 0 && insertValue < arr[insertIndex - distance]) {
                    arr[insertIndex] = arr[insertIndex - distance];
                    insertIndex -= distance;
                }
                //最后赋值值
                arr[insertIndex] = insertValue;
            }
        }

    }
}
