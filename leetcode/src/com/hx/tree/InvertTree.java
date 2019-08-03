package com.hx.tree;

/**
 * 合并二叉树
 *
 * @author jxlgcmh
 * @date 2019-07-22 17:15
 */
public class InvertTree {
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		InvertTree invertTree = new InvertTree();
		invertTree.invertTree(node1);
		TreeNode.preOrder(node1);
		
	}
	
	public  TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		
		root.left = right;
		root.right = left;
		return root;
		
		
	}
}
