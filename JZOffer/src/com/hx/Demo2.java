package com.hx;

/**
 * @author jxlgcmh
 * @date 2019-08-11 17:34
 */
public class Demo2 {
    public static void main(String[] args) {
        int [][] arr ={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        System.out.println(find(arr, 13));
    }

    public static boolean find(int[][] matrix, int target) {
        // 起始非空非0判断
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row =matrix.length;
        int clo =matrix[0].length;
        int r =0;
        int c =clo-1;
        while (r<=row-1 && c>=0) {
            if (target == matrix[r][c]) {
                return true;
            }
            // 目标值更小
            else if (target < matrix[r][c]) {
                c--;
            }else {
                r++;
            }
        }
        return false;
    }
}
