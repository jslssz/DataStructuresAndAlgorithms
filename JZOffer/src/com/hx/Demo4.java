package com.hx;

import com.hx.metadata.Node;

/**
 * 逆序打印链表
 *
 * @author jxlgcmh
 * @date 2019-08-13 16:19
 */
public class Demo4 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next=node2;
        reversePrint(node1);
    }

    public static void reversePrint(Node head) {
        if (head == null) {
            return;
        }
        reversePrint(head.next);
        System.out.println(head);

    }
}
