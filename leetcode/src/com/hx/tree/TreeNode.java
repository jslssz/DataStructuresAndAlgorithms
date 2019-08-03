package com.hx.tree;

/**
 *  二叉树节点
 * @author jxlgcmh
 * @date 2019-07-22 17:14
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
	}
	
	public static void preOrder(TreeNode root) {
		if (root == null) {
			System.out.println("二叉树为空！");
			return;
		}
		System.out.println(root.val);
		if (root.left != null) {
			preOrder(root.left);
		}
		if (root.right != null) {
			preOrder(root.right);
		}
	}
}
