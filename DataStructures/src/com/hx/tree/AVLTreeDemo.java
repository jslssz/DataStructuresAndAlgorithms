package com.hx.tree;

/**
 * @author jxlgcmh
 * @date 2019-08-08 08:20
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        AVLTree avlTree =new AVLTree();
//        int [] arr ={4,3,6,5,7,8};
//        int [] arr ={10,12,8,9,7,6};
        int [] arr ={10,11,8,9,7,6};
        for (int item : arr) {
            avlTree.add(new AVLNode(item));
        }
        avlTree.infixOrder();
        System.out.println("===================");
        System.out.println(avlTree.getRoot());
        System.out.println(avlTree.getRoot().getLeftHigh());
        System.out.println(avlTree.getRoot().getRightHigh());

    }
}



class AVLTree{
    private AVLNode root;

    public void setRoot(AVLNode root) {
        this.root = root;
    }

    public AVLNode getRoot() {
        return root;
    }

    public void delNode(int target) {
        if (root == null) {
            return;
        }

        AVLNode targetNode = search(target);
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
        AVLNode parentNode = searchParent(target);
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


    public AVLNode search(int target) {
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
    public int delRightTreeMin(AVLNode target) {
        AVLNode temp = target;
        while (temp.left != null) {
            temp = temp.left;
        }
        delNode(temp.val);
        return temp.val;
    }


    public AVLNode searchParent(int target) {
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
    public void add(AVLNode node) {
        if (root == null) {
            root = node;
            return;
        }
        root.add(node);
    }
}



/**
 * AVL节点
 */
class AVLNode{
    public int val;
    public AVLNode left;
    public AVLNode right;

    public AVLNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "AVLNode[" +
                val +
                ']';
    }

    /**
     * 添加右旋方法
     */
    public void rightRotate() {
        // 创建一个新的结点,以当前根结点的值为val
        AVLNode newNode = new AVLNode(this.val);
        // 把新节点的右子树设置为当前节点的右子树
        newNode.right=this.right;
        // 把新节点的左子树设置为当前结点左子树的右子树
        newNode.left=this.left.right;
        // 把当前节点的值替换成左子节点的值
        this.val=this.left.val;
        // 把当前节点的左子树设置成当前节点的左子树的左子树
        this.left=this.left.left;
        // 把当前节点的右子树设置成新的节点
        this.right=newNode;
    }



    /**
     * 添加左旋的方法
     */
    public void leftRotate() {
        // 创建一个新的结点,以当前根结点的值为val
        AVLNode newNode = new AVLNode(this.val);
        // 把新节点的左子树设置为当前节点的左子树
        newNode.left=this.left;
        // 把新节点的右子树设置为当前结点右子树的左子树
        newNode.right=this.right.left;
        // 把当前节点的值替换成右子节点的值
        this.val=this.right.val;
        // 把当前节点的左子树设置成当前节点的右子树的右子树
        this.right=this.right.right;
        // 把当前节点的左子树设置成新的节点
        this.left=newNode;
    }



    // 添加获取子树高度的方法

    // 获取左子树的高度
    public int getLeftHigh() {
        if (this.left == null) {
            return 0;
        }
        return this.left.height();
    }

    // 获取右子树的高度
    public int getRightHigh() {
        if (this.right == null) {
            return 0;
        }
        return this.right.height();
    }

    // 获取以该节点自身为根结点的树的高度
    public int  height() {
        // 注意高度的计算
        return Math.max(this.left == null ? 0 : this.left.height(),this.right == null ? 0 : this.right.height())+1;
    }



    /**
     * 递归查找要删除的节点
     *
     * @param target 目标节点的值
     * @return 目标节点
     */
    public AVLNode search(int target) {
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
    public AVLNode searchParent(int target) {
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
    public void add(AVLNode node) {
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

        // 进行相应的旋转
        // 右子树更高,则左旋
        if ((this.getRightHigh() - this.getLeftHigh()) >1) {
            // 还需要进一步判断  如果他的右子树的左子树的高度大于他的右子树的右子树的高度
            if (this.right != null && this.right.getLeftHigh() > this.right.getRightHigh()) {
                //先对右子树进行旋转
                this.right.rightRotate();
                // 然后当前节点进行左旋
                leftRotate();
            }else {// 直接左旋
                leftRotate();
            }
            // 必须添加
            return;
        }
        // 左子树更高,右旋
        if ((this.getLeftHigh() - this.getRightHigh()) >1) {
            // 还需要进一步判断  如果他的左子树的右子树的高度大于他的左子树的高度
            if (this.left != null && this.left.getRightHigh() > this.left.getLeftHigh()) {
                //先对左子树进行旋转
                this.left.leftRotate();
                // 然后当前节点进行左旋
                rightRotate();
            }else {
                rightRotate();
            }
        }
    }

}
