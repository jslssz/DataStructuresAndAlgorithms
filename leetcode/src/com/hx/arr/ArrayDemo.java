package com.hx.arr;

/**
 * @author jxlgcmh
 * @date 2019-08-09 22:12
 */
public class ArrayDemo {

    public static void main(String[] args) {

    }

    public int[] sortArrayByParity(int[] A) {
        int l=0,r=A.length-1;
        while(l<r){

            if(A[l]%2!=0&&A[r]%2==0){
                var t=A[l];
                A[l]=A[r];
                A[r]=t;
            }
            if(A[l]%2==0){
                l++;
            }
            if(A[r]%2!=0){
                r--;
            }
        }
        return A;
    }

}
