package com.hx.list.Interviewquestion;

import com.hx.list.linkedlist.Node;

/**
 * @author jxlgcmh
 * @create 2019-06-10 15:05
 *
 * 求倒数第n个结点
 *
 */
public class Question1 {
	
	//  A->B->C->D    target=3  所以结果是B
	
	/**
	 *
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
	
}
