package com.hx.list.doublelinkedlist;

/**
 * @author jxlgcmh
 * @create 2019-06-09 10:10
 */
public class DLList {
	
	
	/**
	 * 删除某位置的节点
	 * @param head 头节点
	 * @param position 第几个位置
	 * @return
	 */
	public DLLNode delete(DLLNode head,int position){
		if (head == null) {
			System.out.println("链表为空");
			return null;
		}
		int length = getLength(head);
		if (position < 1 || position > length) {
			System.out.println("要删除的位置没有节点");
			return head;
		}
		if (position == 1) {
			DLLNode temp =head.next;
			temp.pre=null;
			head =null;
			return temp;
		} else {
			DLLNode temp =head;
			int count =1;
			while (count < length - 1) {
				temp=temp.next;
				count++;
			}
			temp.next=temp.next.next;
			if (temp.next != null) {
				temp.next.pre=temp;
			}
			
			return head;
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 双向链表的插入
	 * @param head 头结点
	 * @param newNode 待插入结点
	 * @param position 要插入的位置
	 * @return 返回头结点
	 */
	public DLLNode insert(DLLNode head,DLLNode newNode,int position){
		if (head == null) {
			return newNode;
		}
		int length = getLength(head);
		//插入位置不合法
		if (position > length + 1 || position < 1) {
			System.out.println("要插入的位置不合法");
			return head;
		}
		//在第一个位置插入
		if (position == 1) {
			newNode.next=head;
			head.pre=newNode;
			return newNode;
		}else {//中间或者尾部添加结点
			DLLNode temp =head;
			int count =1;
			while (count < position -1){
				temp = temp.next;
				count++;
			}
			//退出循环后的temp是代插入位置的前一个
			newNode.next =temp.next;
			if (temp.next != null) {
				temp.next.pre = newNode;
			}
			temp.next=newNode;
			newNode.pre=temp;
			
		}
		
		return head;
	}
	
	
	public int getLength(DLLNode head) {
		if (head == null) {
			return 0;
		}
		DLLNode current =head;
		int length =0;
		while (current != null) {
			length++;
			current =current.next;
		}
		return length;
	}

	public void  show(DLLNode head) {
		if (head == null) {
			System.out.println("双向链表为空");
			return;
		}
		DLLNode current = head;
		while (current != null) {
			if (current.pre != null) {
				System.out.print("前驱结点编号为："+current.pre.no);
			}
			System.out.print("，自身结点编号为："+current.no);
			if (current.next != null) {
				System.out.print("，后置结点编号为："+current.next.no);
			}
			System.out.println();
			current = current.next;
		}
	}
}
