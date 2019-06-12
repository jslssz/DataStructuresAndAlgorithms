package com.hx.list.Interviewquestion;

import com.hx.list.linkedlist.Node;

/**
 * @author jxlgcmh
 * @create 2019-06-10 15:05
 *
 *
 *
 */
public class Question1 {
	
	//  A->B->C->D    target=3  所以结果是B
	
	/**
	 *求倒数第n个结点
	 * @param head
	 * @param index
	 * @return
	 */
	public Node findLastIndex(Node head, int index) {
		Node pTemp =head;
		Node pIndex =null;
		//PTemp指向目标结点的前一个
		for (int i = 1; i < index; i++) {
			if (pTemp != null) {
				pTemp =pTemp.next;
			}
		}
		//得到temp=C
		
		
		while (pTemp != null) {
			if (pIndex == null) {
				pIndex=head;
				
			}else {
				//此时得到了B
				pIndex =pIndex.next;
				
			}
			pTemp=pTemp.next;
		}
		
		if (pIndex != null) {
			return pIndex;
		}
		return null;
		
		
	}
	
	/**
	 * 判断链表中是否有环
	 * @param head
	 * @return
	 */
	boolean doesHaveLoop(Node head) {
		if (head == null) {
			return  false;
		}
		
		Node fastP=head,slowP =head;
		while (fastP.next.next != null && slowP.next != null) {
			fastP=fastP.next.next;
			slowP=slowP.next;
			if (slowP == fastP) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 判断链表中环的出现位置
	 * @param head
	 * @return
	 */
	Node findBeginHaveLoop(Node head) {
		if (head == null) {
			return null;
		}
		Node fastP=head,slowP =head;
		boolean flag =false;
		while (fastP.next.next != null && slowP.next != null) {
			fastP=fastP.next.next;
			slowP=slowP.next;
			if (slowP == fastP) {
				//出现环，修改标志位
				flag =true;
				break;
			}
		}
		if (flag) {
			slowP=head;
			while (slowP != fastP) {
				fastP=fastP.next;
				slowP=slowP.next;
			}
			return slowP;
		}
		
		return null;
	}
	
	/**
	 * 求链表环的长度
	 * @param head
	 * @return
	 */
	int findLoopLength(Node head) {
		if (head == null) {
			return 0;
		}
		
		Node fastP=head,slowP =head;
		boolean flag =false;
		//用来计数环的长度
		int count=0;
		while (fastP.next.next != null && slowP.next != null) {
			fastP=fastP.next.next;
			slowP=slowP.next;
			if (slowP == fastP) {
				//出现环，修改标志位
				flag =true;
				break;
			}
		}
		if (flag) {
			fastP=fastP.next;
			while (slowP != fastP) {
				fastP=fastP.next;
				count++;
			}
			return count;
		}
		
		return 0;
		
	}
	
	
	
	/**
	 * 通过递归的方式逆向打印链表
	 * @param head
	 */
	public void reversePrintByRecursive(Node head){
		if (head == null) {
			return ;
		}
		reversePrintByRecursive(head.next);
		System.out.println(head);
	}
	
	
	public Node reverseList(Node head) {
		Node temp=null,nextNode=null;
		while (head != null) {
			nextNode=head.next;
			head.next=temp;
			temp=head;
			head=nextNode;
		}
		return temp;
	}
	
	
	
	
}
