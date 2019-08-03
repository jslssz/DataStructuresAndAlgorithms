package com.hx.tree;

import java.util.List;

/**
 *  n叉树节点
 *
 * @author jxlgcmh
 * @date 2019-07-22 17:39
 */
public class Node {
	public int val;
	public List<Node> children;
	
	public Node() {}
	
	public Node(int _val,List<Node> _children) {
		val = _val;
		children = _children;
	}
}
