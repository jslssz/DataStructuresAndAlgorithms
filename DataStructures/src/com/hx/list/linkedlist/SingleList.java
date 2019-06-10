package com.hx.list.linkedlist;

import java.util.Stack;

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
	
	
	public void update(Node node){
		Node temp = head;
		boolean flag =false;
		while (true){
			
			if (temp.next == null){
				break;
			}
			if (temp.next.id == node.id) {
				flag = true;
				break;
			}
			
			temp = temp.next;
		}
		if (flag) {
			temp.next.name=node.name;
			temp.next.nick=node.nick;
		}else {
			System.out.println("你要更新的节点编号不存在");
		}
		
	}
	
	
	public void delete(int id){
		Node temp = head;
		boolean flag = false;
		while (true){
			if (temp.next == null) {
				System.out.println("链表为空");
				break;
			}
			if (temp.next.id == id) {
				flag = true;
				break;
			}
			
			temp=temp.next;
		}
		if (flag) {
			temp.next=temp.next.next;
		}else {
			System.out.println("删除不成功");
		}
		
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
	
	/**
	 * 获取头结点
	 * @return
	 */
	public Node getHead() {
		return head;
	}
	
	
	/**
	 * 获取链表的头结点
	 * @param head
	 * @return
	 */
	public int getLength(Node head){
		Node temp =head;
		if (temp.next ==null){
			return 0;
		}
		
		int count =0;
		while (temp.next !=null){
			count ++;
			temp =temp.next;
		}
		
		return count;
	}
	
	
	/**
	 * 查找倒数第k个结点信息
	 * @return
	 */
	public Node findLastIndexNode(Node head,int index){
		
		if (head.next == null) {
			return null;
		}
		
		int length = getLength(head);
		if (index <= 0 || index > length) {
			System.out.println("下标位置超出范围");
			return  null;
		}
		
		Node current =head.next;
		
		for (int i =0;i<length-index;i++){
			current =current.next;
		}
		
		return current;
	}
	
	/**
	 * 反转链表
	 * @param head
	 */
	public void reverseList(Node head) {
		//链表为空或者结点个数为1直接返回
		if (head.next == null || head.next.next ==null) {
			return;
		}
		
		Node current =head.next;
		
		Node next =null;
		
		Node reverseHead =new Node(0,"","");
		
		while (current !=null){
			
			next = current.next;
			
			current.next = reverseHead.next;
			
			reverseHead.next=current;
			
			current =next;
			
		}
		
		head.next =reverseHead.next;
		
	}
	
	public void reversePrintByStack(Node head) {
		
		if (head.next == null) {
			return;
		}
		
		Stack<Node> nodeStack =new Stack<>();
		Node curr = head.next;
		while (curr !=null) {
			nodeStack.push(curr);
			curr =curr.next;
		}
		while (! nodeStack.empty()) {
			System.out.println(nodeStack.pop());
		}
		
	}
	
	
	
	
	
}
