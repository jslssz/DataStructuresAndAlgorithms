package com.hx.list.doublelinkedlist;

/**
 * @author jxlgcmh
 * @create 2019-06-09 10:02
 */
public class DLLNode {
	public int no;
	public String name;
	public String nick;
	public DLLNode pre;
	public DLLNode next;
	
	public DLLNode() {
	}
	
	public DLLNode(int no, String name, String nick) {
		this.no = no;
		this.name = name;
		this.nick = nick;
	}
	
}
