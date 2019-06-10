package com.hx.list.cyclelinkedlist;

/**
 * @author jxlgcmh
 * @create 2019-06-10 10:57
 */
public class Test {
	public static void main(String[] args) {
		CLLNode node1 =new CLLNode(1);
		CLLNode node2 =new CLLNode(2);
		CLLNode node3 =new CLLNode(3);
		
		CLList clList =new CLList();
		CLLNode head = clList.insert(null, node1);
		clList.insert(head,node2);
		clList.insert(head,node3);
		int length = clList.getLength(head);
		System.out.println("单向循环链表长度为："+length);
		clList.show(head);
		
		System.out.println("删除头结点：");
		CLLNode deleteFirstNode = clList.deleteFirstNode(head);
		clList.show(deleteFirstNode);
		System.out.println("删除末尾结点：");
		CLLNode deleteLastNode = clList.deleteLastNode(deleteFirstNode);
		clList.show(deleteLastNode);
	}
}
