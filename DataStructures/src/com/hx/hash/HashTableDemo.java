package com.hx.hash;

import java.util.Scanner;

/**
 * @author jxlgcmh
 * @create 2019-07-07 22:15
 */
public class HashTableDemo {
	public static void main(String[] args) {
		EmpListArr empListArr = new EmpListArr(7);
		String key = "";
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("add");
			System.out.println("list");
			System.out.println("exit");
			key =in.next();
//			key =in.nextLine();
			switch (key) {
				case "add":
					System.out.println("请输入id：");
					int id = in.nextInt();
					System.out.println("请输入name：");
					String name = in.next();
//					String name = in.nextLine();
					Emp emp = new Emp(id,name);
					empListArr.add(emp);
					break;
				case "list":
					empListArr.list();
					break;
				case "exit":
					in.close();
					System.exit(0);
				default:
					break;
			}
		}
	}
}



/**
 * 定义数组，用来管理链表,这就是table
 */
class EmpListArr {
	
	private EmpList [] empLists;
	
	private int size;
	
	/**
	 * 初始化每条链表，否则报空指针异常
	 * @param size
	 */
	public EmpListArr(int size) {
		this.size = size;
		empLists =new EmpList[size];
		for (int i = 0; i < size; i++) {
			empLists[i] = new EmpList();
			
		}
	}
	
	/**
	 * 添加
	 * @param emp
	 */
	public void add(Emp emp) {
		int hash = hash(emp.id);
		empLists[hash].add(emp);
	}
	
	/**
	 * 遍历所有链表
	 */
	public void list() {
		for (int i = 0; i < size; i++) {
			empLists[i].list(i);
		}
	}
	
	
	/**
	 * 通过id值计算hash值，从而确定放在那个链表
	 * @param id
	 * @return
	 */
	public int hash(int id) {
		return id % size;
	}
	
	
}


/**
 * 定义链表，用来管理节点，或者说是由节点组成
 * 此处的功能是节点的CURD
 */
class EmpList {
	
	private Emp head;
	
	/**
	 * 添加节点
	 *
	 * @param emp
	 */
	public void add(Emp emp) {
		if (head == null) {
			head = emp;
			return;
		}
		
		Emp curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		//直接加入尾部
		curr.next = emp;
		
	}
	
	/**
	 * 遍历链表
	 *
	 * @param no
	 */
	public void list(int no) {
		if (head == null) {
			System.out.println(no + 1 + "号链表为空！");
			return;
		}
		System.out.println(no + 1 + "号链表的信息为：");
		Emp curr = head;
		while (curr != null) {
			System.out.printf("=》id=%d,name=%s\t", curr.id, curr.name);
			curr = curr.next;
		}
		System.out.println();
		
	}
}


/**
 * 定义Emp节点，相当于hashTable中的链表中的节点
 */
class Emp {
	public int id;
	public String name;
	public Emp next;
	
	public Emp(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
