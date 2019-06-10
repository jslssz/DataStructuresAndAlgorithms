package com.hx.list.linkedlist;

/**
 * @author jxlgcmh
 * @create 2019-06-03 11:03
 */
public class Test {
	public static void main(String[] args) {
		Node n1 = new Node(1,"松江","及时雨");
		Node n2 = new Node(2,"卢俊义","玉麒麟");
		Node n3 = new Node(3,"吴用","智多星");
		Node n4 = new Node(4,"武松","行者");
		
		SingleList list =new SingleList();
//		list.add(n1);
//		list.add(n2);
//		list.add(n3);
//		list.add(n4);
		
		list.addByOrder(n1);
		list.addByOrder(n4);
		list.addByOrder(n2);
		list.addByOrder(n3);
		
//		list.list();
//
//		list.update(new Node(4,"武松","打虎武松"));
//
//		System.out.println("更新之后");
//
//		list.list();
		
//		list.delete(4);
//		list.delete(2);
//		list.delete(3);
//		list.delete(1);
//		list.delete(1);
//		list.list();
		
//		System.out.println(list.getLength(list.getHead()));
		
//		Node indexNode = list.findLastIndex(list.getHead(), 3);
//		System.out.println(indexNode);
		
//		list.reverseList(list.getHead());
//		list.list();
		
		//list.reversePrintByStack(list.getHead());
		
	}
}
