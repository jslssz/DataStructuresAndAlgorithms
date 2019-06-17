package com.hx.list.linkedlist;

/**
 * @author jxlgcmh
 * @create 2019-06-12 22:50
 */
public class JosephuaRing {
	public static void main(String[] args) {
		JNode j1=new JNode(11);
		JNode j2=new JNode(22);
		JNode j3=new JNode(33);
		JNode j4=new JNode(44);
		JNode j5=new JNode(55);
		j1.next=j2;
		j2.next=j3;
		j3.next=j4;
		j4.next=j5;
		j5.next=j1;
		
		for (int count =5; count>1;--count) {
			for (int i = 0; i <2- 1; ++i) {
				j1=j1.next;
			}
			j1=j1.next;
		}
		System.out.println(j1.val);
	}
	
	
}
