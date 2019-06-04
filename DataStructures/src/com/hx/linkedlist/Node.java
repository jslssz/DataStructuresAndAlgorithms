package com.hx.linkedlist;

/**
 * @author jxlgcmh
 * @create 2019-06-03 10:45
 */
public class Node {
	
	int id;
	String name;
	String nick;
	public Node next;
	
	public Node(int id, String name, String nick) {
		this.id = id;
		this.name = name;
		this.nick = nick;
	}
	
	@Override
	public String toString() {
		return "Node{" +
				"id=" + id +
				", name='" + name + '\'' +
				", nick='" + nick + '\'' +
				'}';
	}
}
