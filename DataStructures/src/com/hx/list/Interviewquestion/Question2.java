package com.hx.list.Interviewquestion;

import com.hx.list.linkedlist.Node;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jxlgcmh
 * @create 2019-06-10 17:14
 *
 * 判断链表中是否有环
 *
 */
public class Question2 {
	
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
	
}
