package com.hx.stack.interviewquestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转后缀表达式（逆波兰表达式）
 *
 * @author jxlgcmh
 * @create 2019-06-14 11:50
 */
public class GoodPolandCalculator {
	
	public static void main(String[] args) {
		//String expression = "A*B-(C+D)+E";
		String expression = "2*(9-5)+5-1";
		System.out.println("中缀表达式：" + expression);
		
		
		String polandExpression = toPolandExpression(expression);
		System.out.println("逆波兰表达式：" + polandExpression);
		
		List list = getList(polandExpression);
		int res = cal(list);
		System.out.println("计算结果："+res);
		
		
	}
	
	public  static String toPolandExpression(String str) {
		Stack<String> stack = new Stack<>();
		char[] chars = str.toCharArray();
		int length = chars.length;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char ch = chars[i];
			//是操作符，入栈
			if (isOpr(ch)) {
				//左括号
				if (ch == '(') {
					stack.push(String.valueOf(ch));
					
				}
				//右括号
				else if (ch == ')') {
					//左括号只弹出并不输出
					String pop = stack.peek();
					while (pop.charAt(0) != '(') {
						//非左括号
						String pop1 = stack.pop();
						builder.append(pop1);
						pop = stack.peek();
					}
					//此时再把“（”pop出去
					stack.pop();
					
					
				}
				//操作符 + - * /
				else {
					if (stack.empty()) {
						stack.push(String.valueOf(ch));
					} else {
						while (!stack.empty()) {
							//操作符栈栈顶为'('
							if (stack.peek().charAt(0) == '(') {
								break;
							}
							//栈顶操作符优先级小
							if (priority(ch) > priority(stack.peek().charAt(0))) {
								break;
							}
							//栈顶操作符优先级大，
							else {
								//栈顶操作符出栈
								String pop = stack.pop();
								//输出
								builder.append(pop);
							}
						}
						//操作符入栈
						stack.push(String.valueOf(ch));
					}
				}
			}
			//操作符，直接输出
			else {
				builder.append(ch);
			}
			//打印出入栈过程
			System.out.println(builder.toString());
		}
		//把操作符栈的元素全部出栈
		while (!stack.empty()) {
			builder.append(stack.pop());
		}
		
		String res = builder.toString();
		//System.out.println(res);
		return res;
		
	}
	
	/**
	 * 判断是否为操作符
	 * @param ch
	 * @return
	 */
	public static boolean isOpr(char ch) {
		String oprString = "+-*/()";
		return oprString.indexOf(ch) > -1;
	}
	
	/**
	 * 比较优先级
	 * @param opr
	 * @return
	 */
	public static int priority(int opr) {
		if (opr == '*' || opr == '/') {
			return 2;
		} else if (opr == '+' || opr == '-') {
			return 1;
		} else {
			return -1;
		}
	}
	
	/**
	 * 计算
	 * @param list
	 * @return
	 */
	public static int cal(List<String> list) {
		int num1, num2, res;
		Stack<String> stack = new Stack<>();
		for (String item : list) {
			//使用正则表达式，判断是不是数
			if (item.matches("\\d+")) {
				stack.push(item);
			} else {
				num1 = Integer.parseInt(stack.pop());
				num2 = Integer.parseInt(stack.pop());
				if (item.equals("+")) {
					res = num1 + num2;
				} else if (item.equals("-")) {
					res = num2 - num1;
				} else if (item.equals("*")) {
					res = num2 * num1;
				} else if (item.equals("/")) {
					res = num2 / num1;
				} else {
					throw new RuntimeException("非法！");
				}
				stack.push(String.valueOf(res));
			}
		}
		
		return Integer.parseInt(stack.pop());
	}
	
	
	public static List getList(String string) {
		List<String> list = new ArrayList<>();
		
		char[] chars = string.toCharArray();
		for (int i = 0; i < chars.length; i++) {
				list.add(chars[i]+"");
			}
		
		return list;
	}
	
}
