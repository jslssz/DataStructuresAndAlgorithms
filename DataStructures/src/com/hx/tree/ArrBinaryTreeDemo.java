package com.hx.tree;

/**
 * @author jxlgcmh
 * @create 2019-07-14 22:12
 */
public class ArrBinaryTreeDemo {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
		//arrBinaryTree.preOrder();
		arrBinaryTree.infixOrder();
		
	}
}

class ArrBinaryTree {
	private int[] arr;
	
	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
	}
	
	/**
	 * 重载，方便调用
	 */
	public void preOrder() {
		this.preOrder(0);
	}
	
	
	public void infixOrder() {
		this.infixOrder(0);
	}
	
	/**
	 * 前序遍历数组
	 *
	 * @param index
	 */
	public void preOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空，不能按照二叉树的前序遍历！");
		}
		// 输出当前下表的元素
		System.out.println(arr[index]);
		
		// 向左递归遍历
		if ((index * 2 + 1) < arr.length) {
			preOrder(2 * index + 1);
		}
		
		// 向右递归遍历
		if ((index * 2 + 2) < arr.length) {
			preOrder(2 * index + 2);
		}
	}
	
	public void infixOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空，不能按照二叉树的前序遍历！");
		}
		
		// 向左递归遍历
		if ((index * 2 + 1) < arr.length) {
			infixOrder(2 * index + 1);
		}
		
		// 输出当前下表的元素
		System.out.println(arr[index]);
		
		// 向右递归遍历
		if ((index * 2 + 2) < arr.length) {
			infixOrder(2 * index + 2);
		}
		
	}
}