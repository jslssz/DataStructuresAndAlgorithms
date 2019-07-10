package com.hx.tree;


import java.util.IllegalFormatFlagsException;

/**
 * @author jxlgcmh
 * @create 2019-07-09 22:13
 */
public class BinaryTreeDemo {
	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(1, "a");
		TreeNode node2 = new TreeNode(2, "b");
		TreeNode node3 = new TreeNode(3, "c");
		TreeNode node4 = new TreeNode(4, "d");
		TreeNode node5 = new TreeNode(5, "e");
		
		node1.left =node2;
		node1.right =node3;
		node3.left=node5;
		node3.right=node4;
		
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.setRoot(node1);
		//binaryTree.toPreOrder();
		//binaryTree.toInfixOrder();
		//binaryTree.toPostOrder();
		//TreeNode resNode = binaryTree.toPreFind(5);
		TreeNode resNode = binaryTree.toInfixFind(5);
		System.out.println(resNode.name);
	}
}


class BinaryTree {
	
	private TreeNode root;
	
	/**
	 * 二叉树管理这些树节点
	 *
	 * @param root
	 */
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public void toPreOrder() {
		if (root == null) {
			System.out.println("当前二叉树为空！");
			return;
		}
		
		this.root.preOrder();
	}
	
	public TreeNode toPreFind(int target) {
		if (root == null) {
			System.out.println("当前二叉树为空！");
			return  null;
		}
		
		return this.root.preFind(target);
	}
	
	
	public void toInfixOrder() {
		if (root == null) {
			System.out.println("当前二叉树为空！");
			return ;
		}
		 this.root.infixOrder();
	}
	
	public TreeNode toInfixFind(int target) {
		if (root == null) {
			System.out.println("当前二叉树为空！");
			return null;
		}
		return this.root.infixFind(target);
	}
	
	public void toPostOrder() {
		if (root == null) {
			System.out.println("当前二叉树为空！");
			return;
		}
		this.root.postOrder();
	}
	
	
}


class TreeNode {
	public int id;
	public String name;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return id+"\t" ;
	}
	
	/**
	 * 前序遍历
	 */
	public void preOrder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}
	
	/**
	 * 前序查找
	 * @param target
	 * @return
	 */
	public TreeNode preFind(int target) {
		if (this.id == target) {
			return this;
		}
		TreeNode resNode = null;
		if (this.left != null) {
			resNode = this.left.preFind(target);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.right != null) {
			resNode = this.right.preFind(target);
		}
		return resNode;
	}
	
	
	
	
	/**
	 * 中序遍历
	 */
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	
	/**
	 * 中序查找
	 * @param target
	 * @return
	 */
	public TreeNode infixFind(int target) {
		TreeNode resNode = null;
		if (this.left != null) {
			resNode =this.left.infixFind(target);
		}
		/*if (resNode.id == target) {
			return resNode;
		}*/
		if (resNode != null) {
			return resNode;
		}
		
		if (this.id == target) {
			return  this;
		}
		if (this.right != null) {
			resNode =this.right.infixFind(target);
		}
		return resNode;
	}
	
	
	
	/**
	 * 后序遍历
	 */
	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}
	
	/**
	 * 后序查找
	 */
	public TreeNode postFind(int target) {
		TreeNode resNode =null;
		if (this.left != null) {
			resNode =this.left.preFind(target);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.right != null) {
			resNode =this.right.postFind(target);
		}
		if (resNode != null) {
			return  resNode;
		}
		if (this.id == target) {
			return this;
		}
		
		return resNode;
		
	}
	
	
	
}


