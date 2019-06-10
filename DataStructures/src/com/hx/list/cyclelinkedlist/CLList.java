package com.hx.list.cyclelinkedlist;

/**
 * @author jxlgcmh
 * @create 2019-06-10 10:50
 * 这是一个环形链表
 *
 */
public class CLList {
	
	/**
	 * 删除第一个结点
	 * @param head
	 * @return
	 */
	public CLLNode deleteFirstNode(CLLNode head) {
		CLLNode current =head;
		if (head == null) {
			System.out.println("List Empty");
			return null;
		}
		while (current.next != head) {
			current=current.next;
		}
		current.next=head.next;
		head=head.next;
		return head;
	}
	
	
	
	
	/**
	 * 删除最后一个结点
	 * @param head
	 * @return
	 */
	public CLLNode deleteLastNode(CLLNode head) {
		CLLNode temp =head;
		CLLNode current =head;
		if (head == null) {
			System.out.println("List Empty");
			return null;
		}
		
		//此时的结果，是temp一直是current的前驱结点
		while (current.next != head) {
			temp =current;
			current=current.next;
		}
		temp.next=head;
		//置current为空,按道理可以不用，GC应该会自动回收
		current =null;
		return head;
	}
	
	
	/**
	 * 显示单链表中所有的元素
	 * @param head
	 */
	public void show(CLLNode head) {
		CLLNode current =head;
		while (current != null) {
			System.out.print(current.id+"->");
			current=current.next;
			if (current == head) {
				break;
			}
		}
	}
	
	
	
	
	/**
	 * 获取单向循环链表的长度
	 * @param head
	 * @return
	 */
	public int getLength(CLLNode head) {
		if (head == null) {
			return 0;
		}
		int count =1;
		CLLNode current =head;
		while (current.next != head) {
			count++;
			current=current.next;
		}
		return count;
		
		
	}
	
	
	/**
	 * 插入单向循环链表
	 * @param head 指定头结点
	 * @param newNode 指定代插入结点
	 */
	public CLLNode insert(CLLNode head, CLLNode newNode) {
		//1.先把要插入单向循环链表的结点的next域指向其本身
		newNode.next = newNode;
		if (head == null) {
			head = newNode;
			return head;
		}
		
		CLLNode current = head;
		while (current.next != head) {
			current = current.next;
		}
		newNode.next = head;
		current.next = newNode;
		
		return head;
	}
}
