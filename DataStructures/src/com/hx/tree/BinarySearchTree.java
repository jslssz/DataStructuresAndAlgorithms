package com.hx.tree;

/**
 * 二叉搜索树,或成二叉排序树,简称BST
 * @author jxlgcmh
 * @date 2019-08-07 10:54
 */
public class BinarySearchTree {
    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        int[] arr ={7,3,10,12,5,1,9};
        for (int item : arr) {
            bsTree.add(new BSTNode(item));
        }
        bsTree.infixOrder();




    }
}
class BSTree{
    private BSTNode root;

    public void setRoot(BSTNode root) {
        this.root = root;
    }


    public void infixOrder() {
        if (root == null) {
            System.out.println("BST为空!");
            return;
        }
        root.infixOrder();
    }

    /**
     * 添加
     * @param node
     */
    public void add(BSTNode node) {
        if (root == null) {
            root = node;
            return;
        }
        root.add(node);
    }
}
/**
 * 二叉搜索树的节点
 */
class BSTNode{

    public int val;
    public BSTNode left;
    public BSTNode right;

    public BSTNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "BSTNode[" +
                 val +
                ']';
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
     *  往BST中添加节点,或者说是构造BST
     * @param node
     */
    public void add(BSTNode node) {
        if (node == null) {
            return;
        }
        if (node.val < this.val) {
            if (this.left == null) {
                this.left=node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right == null) {
                this.right =node;
            }else {
                this.right.add(node);
            }
        }
    }

}
