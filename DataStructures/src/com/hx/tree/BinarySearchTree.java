package com.hx.tree;

/**
 * 二叉搜索树,或成二叉排序树,简称BST
 *
 * @author jxlgcmh
 * @date 2019-08-07 10:54
 */
public class BinarySearchTree {
    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        for (int item : arr) {
            bsTree.add(new BSTNode(item));
        }
        bsTree.infixOrder();
        bsTree.delNode(10);
        System.out.println("========================");
        bsTree.infixOrder();


    }
}

class BSTree {
    private BSTNode root;

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    public void delNode(int target) {
        if (root == null) {
            return;
        }

        BSTNode targetNode = search(target);
        if (targetNode == null) {
            System.out.println("目标节点不存在");
            return;
        }
        // 如果没有子节点节点
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }
        // 有父节点
        BSTNode parentNode = searchParent(target);
        // 是叶子节点
        /**
         * 1.找到目标节点
         * 2.找到对应的父节点
         * 3.确定目标节点是左子节点或者右子节点
         * 4.确定情况
         * 5.进行删除
         * 6.左parent.left =null
         * 7.右parent.right =null
         */
        if (targetNode.left == null && targetNode.right == null) {
            // 通过对象的形式判断,没有通过值额方式判断
            if (parentNode.left != null && parentNode.left == targetNode) {
                parentNode.left = null;
            } else if (parentNode.right != null && parentNode.right == targetNode) {
                parentNode.right = null;
            }
        }
        // 有两颗子树
        /**
         * 1.找到目标节点
         * 2.找到目标节点的父节点
         * 3.找到右子树的最小节点
         * 4.用临时变量temp保存最小节点
         * 5.删除最小节点
         * 6.把temp的值赋值给target.val=temp.val
         */
        else if (targetNode.left != null && targetNode.right != null) {
            int rightTreeMin = delRightTreeMin(targetNode.right);
            targetNode.val = rightTreeMin;
        } else {
            /**
             * 3.确定目标节点的子节点是左子节点还是右子节点
             * 4.如果子节点是左子节点
             * 4.1.如果target是父节点的左子节点
             * parent.left=target.left
             * 4.2.如果target是父节点的右子节点
             * parent.right=target.left
             * 5.如果子节点是右子节点
             * 5.1.如果target是父节点的左子节点
             * parent.left=target.right
             * 5.2.如果target是父节点的右子节点
             * parent.right=target.right
             */
            if (targetNode.left != null) {
                //parentNode  的非空判断
                if (parentNode != null) {
                    if (parentNode.left == targetNode) {
                        parentNode.left = targetNode.left;
                    } else {
                        parentNode.right = targetNode.left;
                    }
                } else {
                    root = targetNode.left;
                }

            } else {
                if (parentNode.right != null) {
                    if (parentNode != null) {
                        if (parentNode.left == targetNode) {
                            parentNode.left = targetNode.right;
                        } else {
                            parentNode.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }

        }
    }


    public BSTNode search(int target) {
        if (root == null) {
            return null;
        }
        return root.search(target);
    }


    /**
     * 删除
     * <p>
     * 3.找到右子树的最小节点
     * 4.用临时变量temp保存最小节点
     * 5.删除最小节点
     * 6.把temp的值赋值给target.val=temp.val
     *
     * @param target 目标节点
     * @return 最小节点的值
     */
    public int delRightTreeMin(BSTNode target) {
        BSTNode temp = target;
        while (temp.left != null) {
            temp = temp.left;
        }
        delNode(temp.val);
        return temp.val;
    }


    public BSTNode searchParent(int target) {
        if (root == null) {
            return null;
        }
        return root.searchParent(target);
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (root == null) {
            System.out.println("BST为空!");
            return;
        }
        root.infixOrder();
    }

    /**
     * 添加
     *
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
class BSTNode {

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
     * 递归查找要删除的节点
     *
     * @param target 目标节点的值
     * @return 目标节点
     */
    public BSTNode search(int target) {
        if (target == this.val) {
            return this;
        } else if (target < this.val) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(target);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(target);
        }
    }

    /**
     * 查找父节点  因为二叉树是单向的,所以要在写一个方法
     *
     * @param target 目标节点
     * @return 父节点
     */
    public BSTNode searchParent(int target) {
        // 当前节点就是
        if (this.left != null && this.left.val == target || this.right != null && this.right.val == target) {
            return this;
        } else {
            // 更小往左找
            if (target < this.val && this.left != null) {
                return this.left.searchParent(target);
            }
            // 更大往右找
            else if (target >= this.val && this.right != null) {
                return this.right.searchParent(target);
            }
            // 没找到
            else {
                return null;
            }
        }
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
     * 往BST中添加节点,或者说是构造BST
     *
     * @param node
     */
    public void add(BSTNode node) {
        if (node == null) {
            return;
        }
        if (node.val < this.val) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

}
