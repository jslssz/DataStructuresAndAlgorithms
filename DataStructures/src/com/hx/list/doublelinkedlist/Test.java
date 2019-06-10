package com.hx.list.doublelinkedlist;

/**
 * @author jxlgcmh
 * @create 2019-06-09 10:18
 */
public class Test {
	public static void main(String[] args) {
		
		//初始化双向链表   d1 <->d2 <->d3
		
		DLLNode d1 = new DLLNode(1, "A", "a");
		DLLNode d2 = new DLLNode(2, "B", "b");
		DLLNode d3 = new DLLNode(3, "C", "c");
		d1.next = d2;
		d2.next = d3;
		d2.pre = d1;
		d3.pre = d2;
		
		
		DLList dlList = new DLList();
		dlList.show(d1);
		int length = dlList.getLength(d1);
		System.out.println("双向链表长度为：" + length);
		
		//测试添加结点
		//添加在第一个位置
	/*	DLLNode newNode =new DLLNode(4,"C","c");
		DLLNode head = dlList.insert(d1, newNode, 1);
		dlList.show(head);
		int length2 = dlList.getLength(head);
		System.out.println("双向链表长度为："+length2);*/
		//添加在中间位置
//		DLLNode newNode = new DLLNode(4, "C", "c");
//		DLLNode head = dlList.insert(d1, newNode, 3);
//		dlList.show(head);
//		int length2 = dlList.getLength(head);
//		System.out.println("双向链表长度为：" + length2);
		
		//测试删除
		DLLNode dllNode = dlList.delete(d1, 3);
		dlList.show(dllNode);
		int length1 = dlList.getLength(dllNode);
		System.out.println("双向链表长度为：" + length1);
		
	}
}
