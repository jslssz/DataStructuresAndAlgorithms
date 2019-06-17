package com.hx.stack.hsp;

/**
 * 通过栈来实现无括号的计算器
 *
 * @author jxlgcmh
 * @create 2019-06-14 15:26
 */
public class Calculator {
	public static void main(String[] args) {
		String expression = "7*2*2-5+1-5+3-4";
		
		//res=39
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 oprStack = new ArrayStack2(10);
		
		//定义需要的相关变量
		
		//记录入表达式指针所在位置
		int index = 0;
		int num1 ;
		int num2 ;
		int opr ;
		int res ;
		//暂存字符
		char ch = ' ';
		//用于拼接多位数
		String keepNum = "";
		
		while (true) {
			ch = expression.substring(index, index + 1).charAt(0);
			if (oprStack.isOpr(ch)) {
				if (!oprStack.isEmpty()) {
					//当前准备入栈的操作符的优先级  小于操作符栈栈内操作的符的优先级
					if (oprStack.priority(ch) <= oprStack.priority(oprStack.peek())) {
						//则原先的数要先计算，然后结果入数栈
						num1 = numStack.pop();
						num2 = numStack.pop();
						opr = oprStack.pop();
						res = numStack.cal(num1, num2, opr);
						numStack.push(res);
						//再将操作符入栈
						oprStack.push(ch);
					} else {//操作符优先级更大
						oprStack.push(ch);
					}
				} else {//操作符栈为空
					oprStack.push(ch);
				}
			} else {//此时是操作数栈，需要判断是否是多位的
				keepNum += ch;
				//防止数组下标越界
				if (index == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				} else {
					//判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
					//注意是看后一位，不是index++
					if (oprStack.isOpr(expression.substring(index + 1, index + 2).charAt(0))) {
						//如果后一位是运算符，则入栈 keepNum = "1" 或者 "123"
						numStack.push(Integer.parseInt(keepNum));
						//重要的!!!!!!, keepNum清空
						keepNum = "";
						
					}
				}
			}
			//继续向下扫描
			index ++;
			
			//跳出，表达式入栈操作完毕
			if (index >= expression.length()) {
				break;
			}
		}
		
		while (true) {
			if (oprStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			opr = oprStack.pop();
			res = numStack.cal(num1, num2, opr);
			numStack.push(res);
			
		}
		System.out.printf("%s=%d",expression,numStack.pop());
		
	}
}

class ArrayStack2 {
	private int maxSize;
	private int top = -1;
	private int[] arr;
	
	public ArrayStack2(int maxSize) {
		this.maxSize = maxSize;
		this.arr = new int[maxSize];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	public void push(int data) {
		if (isFull()) {
			System.out.println("栈满！");
			return;
		}
		arr[++top] = data;
	}
	
	public int pop() {
		if (isEmpty()) {
			System.out.println("栈空！");
			throw new RuntimeException("");
		}
		return arr[top--];
	}
	
	/**
	 * 操作符使用char类型，故可以直接使用int来接收
	 *
	 * @param opr
	 * @return
	 */
	public int priority(int opr) {
		if (opr == '*' || opr == '/') {
			return 2;
		} else if (opr == '+' || opr == '-') {
			return 1;
		} else {
			return -1;
		}
	}
	
	
	//判断是不是一个运算符
	public boolean isOpr(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}
	
	/**
	 * 返回栈顶元素
	 *
	 * @return
	 */
	public int peek() {
		return arr[top];
	}
	
	/**
	 * 计算方法
	 *
	 * @param num1 操作数1
	 * @param num2 操作数2
	 * @param opr  操作符
	 * @return
	 */
	public int cal(int num1, int num2, int opr) {
		int res = 0;
		switch (opr) {
			case '+':
				res = num1 + num2;
				break;
			case '-':
				res = num2 - num1;
				break;
			case '*':
				res = num1 * num2;
				break;
			case '/':
				res = num2 / num1;
				break;
			default:
				break;
		}
		return res;
	}
	
}