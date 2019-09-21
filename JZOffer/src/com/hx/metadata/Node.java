package com.hx.metadata;

/**
 * @author jxlgcmh
 * @date 2019-08-13 16:20
 */
public class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                + val +
                '}';
    }
}
