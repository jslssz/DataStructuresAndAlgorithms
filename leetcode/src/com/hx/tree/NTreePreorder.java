package com.hx.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jxlgcmh
 * @date 2019-07-22 17:41
 */
public class NTreePreorder {
	public static void main(String[] args) {
	
	}
	
	public List<Integer> preOrder(Node root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		
		res.add(root.val);
		List<Node> childrens = root.children;
		if (childrens != null) {
			for (Node children : childrens) {
				preOrder(children);
			}
		}
		
		return res;
		
	}
}
