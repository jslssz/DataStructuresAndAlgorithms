package com.hx.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jxlgcmh
 * @date 2019-08-04 08:42
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        List<Node> nodeList = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            // 创建节点
            nodeList.add(new Node(arr[i]));
        }
        // 排序
        Collections.sort(nodeList);
        System.out.println(nodeList);
        Node leftNode = nodeList.get(0);
        Node rightNode = nodeList.get(1);
        // 创建新的父节点
        Node parent = new Node(leftNode.val + rightNode.val);
        parent.left = leftNode;
        parent.right = rightNode;
        // 将前面已经构建的左右子节点从list中除去
        nodeList.remove(leftNode);
        nodeList.remove(rightNode);
        // 将parent 添加到list中
        nodeList.add(parent);
        // 重新排序  如果是while循环则不用再此处排序
        Collections.sort(nodeList);
        System.out.println(nodeList);
    }
}

class Node implements Comparable<Node> {

    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node[" + val + ']';
    }


    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }
}
