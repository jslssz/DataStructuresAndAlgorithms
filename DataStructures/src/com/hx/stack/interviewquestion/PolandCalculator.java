package com.hx.stack.interviewquestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 逆波兰表达式的计算
 * @author jxlgcmh
 * @create 2019-06-15 11:30
 */
public class PolandCalculator {
	public static void main(String[] args) {
		
		//定义一个逆波兰表达式
		String expr ="3 4 + 5 * 6 -";
		List<String> list = getList(expr);
		int res = cal(list);
		System.out.println(res);
		
	}
	
	
	public static int cal(List<String> list) {
		int num1 ,num2,res;
		Stack<String> stack =new Stack<>();
		for (String item : list) {
			//使用正则表达式，判断是不是数
			if (item.matches("\\d+")) {
				stack.push(item);
			}else {
				num1= Integer.parseInt(stack.pop());
				num2 = Integer.parseInt(stack.pop());
				if (item.equals("+")) {
					res =num1+num2;
				}
				else if (item.equals("-")) {
					res =num2 -num1;
				}
				else if (item.equals("*")) {
					res =num2 * num1;
				}
				else if (item.equals("/")) {
					res =num2 / num1;
				}else {
					throw  new RuntimeException("非法！");
				}
				stack.push(String.valueOf(res));
			}
		}
		
		return Integer.parseInt(stack.pop());
	}
	
	
	public static List getList(String string) {
		List<String> list =new ArrayList<>();
		String[] splits = string.split(" ");
		for (String split : splits) {
			list.add(split);
		}
		return list;
	}
	

}
