package com.hx.linkedlist;

/**
 * @author jxlgcmh
 * @create 2019-06-03 10:44
 */
public class SingleList {
	/**
	 * 初始化头结点
	 */
	private Node head =new Node(0,"","");
	
	/**
	 * 直接添加到链表的尾部
	 * @param node
	 */
	public void add(Node node) {
		Node temp = head;
		while (temp.next != null){
			temp = temp.next;
		}
		temp.next = node;
	}
	
	
	/**
	 * 按编号顺序添加
	 * @param node
	 */
	public void addByOrder(Node node) {
		Node temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			if ( node.id < temp.next.id ) {
				break;
			}
			if (temp.id == node.id) {
				//此处还需要加逻辑判断，不能添加
				break;
			}
			temp =temp.next;
		}
		
		
		node.next=temp.next;
		temp.next = node;
		
		
		
	}
	
	
	
	
	/**
	 * 遍历链表
	 */
	public void list() {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		
		Node temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp =temp.next;
			
		}
		
	}
	
}
