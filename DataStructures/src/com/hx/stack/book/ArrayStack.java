package com.hx.stack.book;

/**
 * 基于数组的实现
 * @author jxlgcmh
 * @create 2019-06-14 10:47
 */
public class ArrayStack {
	private int top;
	private int capacity;
	private int  [] arr;
	
	public ArrayStack() {
		this.top = -1;
		this.capacity = 1;
		this.arr = new int [capacity];
	}
	
	public boolean isEmpty(){
		return top ==-1;
	}
	
	public boolean isFull(){
		return (top==capacity-1);
	}
	
	public void push(int data) {
		if (isFull()) {
			System.out.println("栈满");
		}else {
			arr[++top] =data;
		}
	}
	public int pop(){
		if (isEmpty()) {
			System.out.println();
			return 0;
		}else {
			return arr[top--];
		}
	}
	
}
