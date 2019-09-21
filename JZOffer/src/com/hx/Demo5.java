package com.hx;


import com.hx.metadata.TreeNode;

/**
 * @author jxlgcmh
 * @date 2019-08-13 21:26
 */
public class Demo5 {

    public static void main(String[] args) {
        int[] pre ={1,2,4,7,3,5,6,8};
        int[] in ={4,7,2,1,5,3,8,6};

        Demo5 demo5 =new Demo5();
        TreeNode treeNode = demo5.reConstructBinaryTree(pre, in);
        System.out.println(treeNode.left.val);
        System.out.println(treeNode.right.val);

    }


    private TreeNode reConstructBinaryTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null) {
            return null;
        }
        return construct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    /**
     *
     * @param preOrder 前序遍历的数组
     * @param startPre 前序遍历指针
     * @param endPre  数组长度
     * @param inOrder  中序遍历的数组
     * @param startIn  前序遍历指针
     * @param endIn  数组长度
     * @return  返回根节点
     */
    private TreeNode construct(int[] preOrder, int startPre, int endPre, int[] inOrder, int startIn, int endIn) {
        // 开始位置大于结束位置说明已经没有需要处理的元素了
        if (startPre > endPre) {
            return null;
        }
        int value = preOrder[startPre];
        int index = startIn;
        while (index <= endIn && value != inOrder[index]) {
            index++;
        }
        TreeNode node = new TreeNode(value);
        node.val = value;
        node.left = construct(preOrder, startPre + 1, startPre + index - startIn, inOrder, startIn, index - 1);
        node.right = construct(preOrder, startPre + index - startIn + 1, endPre, inOrder, index + 1, endIn);
        return node;
    }
}
