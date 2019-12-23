package com.hx.arr;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

/**
 * @author jxlgcmh
 * @data 2019-11-12 19:50
 */
public class Arr {

    public static void main(String[] args) {
        int []arr ={0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(arr);
    }


    /**
     *  给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int len=nums.length;
        if (len ==0) {
            return 0;
        }
        int i=0;
        for(int j=1;j<len;j++) {
            //[0,0,1,1,1,2,2,3,3,4],
            if (nums[i] !=nums[j]) {
                i++;//4
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
