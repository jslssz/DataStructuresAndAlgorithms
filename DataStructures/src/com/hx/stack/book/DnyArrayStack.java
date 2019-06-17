package com.hx.stack.book;

/**
 * 基于动态数组实现栈
 *
 * @author jxlgcmh
 * @create 2019-06-14 10:58
 */
public class DnyArrayStack {
	private int top;
	private int capacity;
	private int[] arr;
	
	public DnyArrayStack() {
		this.top = -1;
		this.capacity = 1;
		this.arr = new int[capacity];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return (top == capacity - 1);
	}
	
	public void push(int data) {
		if (isFull()) {
			resize();
		}
		arr[++top] = data;
		
	}
	
	public int pop(){
		if (isEmpty()) {
			System.out.println();
			return 0;
		}else {
			return arr[top--];
		}
	}
	
	
	public void resize() {
		int[] newArray = new int[capacity * 2];
		System.arraycopy(arr, 0, newArray, 0, capacity);
		capacity = capacity * 2;
		arr = newArray;
	}
}
