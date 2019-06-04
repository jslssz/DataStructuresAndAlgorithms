package com.hx.queue;

import java.util.Scanner;

/**
 * @author jxlgcmh
 * @create 2019-06-02 16:10
 */
public class CircleQueue {
	public static void main(String[] args) {
		System.out.println("测试环形队列");
		Queue queue = new Queue(4);
		while (true) {
			System.out.println("请输入以下指示操作：");
			System.out.println("add： 入队");
			System.out.println("get： 出队");
			System.out.println("show：查看队中所有元素");
			System.out.println("head：查看队头元素");
			System.out.println("exit：退出模拟环形队列系统");
			Scanner in = new Scanner(System.in);
			String key = in.nextLine();
			switch (key) {
				case "add":
					System.out.println("请输入一个整数：");
					int n = in.nextInt();
					queue.addQueue(n);
					break;
				
				case "get":
					System.out.println(queue.getQueue());
					break;
				
				case "show":
					queue.listQueue();
					break;
				
				case "head":
					System.out.println(queue.getHead());
					break;
				
				case "exit":
					System.exit(0);
					break;
					//这个代码好奇怪
				default:
					break;
			}
		}
	}
}

class Queue {
	/**
	 * 最大容量
	 */
	private int maxSize;
	private int head;
	private int tail;
	private int[] arr;
	
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
		//一下两个可以不写
		head = 0;
		tail = 0;
	}
	
	public boolean isFull() {
		return (tail + 1) % maxSize == head;
	}
	
	public boolean isEmpty() {
		return tail == head;
	}
	
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("队满");
			return;
		}
		arr[tail] = n;
		//后移尾指针
		tail = (tail + 1) % maxSize;
	}
	
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException();
		}
		//保存零时变量
		int value = arr[head];
		
		head = (head + 1) % maxSize;
		
		return value;
		
	}
	
	public void listQueue() {
		if (isEmpty()) {
			System.out.println("队空");
			return;
		}
		for (int i = head; i < head + getSize(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}
	
	public int getHead() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		return arr[head];
	}
	
	/**
	 * 返回当前队列的有效数据
	 *
	 * @return
	 */
	public int getSize() {
		return (tail + maxSize - head) % maxSize;
	}
	
	
}
