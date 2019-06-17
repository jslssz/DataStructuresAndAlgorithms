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
public class Exe2 {
	
	public static void main(String[] args) {
		//String expression = "10*5*(10-8)+10-10";
		String expression = "(1)";
		System.out.println("中缀表达式：" + expression);
		Exe2 exe2 = new Exe2();
		//中缀表达式转为list集合
		List<String> listTemp = toStringList(expression);
		//转为后缀表达式的list集合
		List<String> listPolandExpression1 = exe2.toPolandExpression3(listTemp);
		List<String> listPolandExpression2= exe2.toPolandExpression4(listTemp);
		
		System.out.println("逆波兰表达式1：" + listPolandExpression1.toString());
		System.out.println("逆波兰表达式2：" + listPolandExpression2.toString());
		
		int res1 = cal(listPolandExpression1);
		int res2 = cal(listPolandExpression2);
		System.out.println("计算结果：" + res1);
		System.out.println("计算结果：" + res2);
		
		
		
		
	}
	
	
	public String toPolandExpression1(String str) {
		Stack<Character> stack = new Stack<>();
		char[] chars = str.toCharArray();
		int length = chars.length;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char ch = chars[i];
			//是操作符，入栈
			if (isOpr(ch)) {
				//左括号
				if (ch == '(') {
					stack.push(ch);
					//如果是右括号
				} else if (ch == ')') {
					//左括号只弹出并不输出
					Character pop = stack.peek();
					while (pop != '(') {
						//非左括号
						Character pop1 = stack.pop();
						builder.append(pop1);
						pop = stack.peek();
					}
					//此时再把“（”pop出去
					stack.pop();
					
					//如果是操作符 +-*//
				} else {
					if (stack.empty()) {
						stack.push(ch);
					} else {
						while (!stack.empty()) {
							if (stack.peek() == '(') {
								break;
							}
							//如果优先级更大
							if (priority(ch) > priority(stack.peek())) {
								break;
							} else {
								Character pop = stack.pop();
								builder.append(pop);
							}
						}
						stack.push(ch);
					}
				}
			} else {
				
				builder.append(ch);
			}
			//打印出入栈过程
			//System.out.println(builder.toString());
		}
		while (!stack.empty()) {
			builder.append(stack.pop());
		}
		//System.out.println(builder.toString());
		String res = builder.toString();
		return res;
		
	}
	
	/**
	 * 转为波兰表达式的链表
	 *
	 * @param str
	 * @return
	 */
	public List<String> toPolandExpression2(String str) {
		Stack<Character> stack = new Stack<>();
		char[] chars = str.toCharArray();
		int length = chars.length;
		List<String> list = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			char ch = chars[i];
			//是操作符，入栈
			if (isOpr(ch)) {
				//左括号
				if (ch == '(') {
					stack.push(ch);
					//如果是右括号
				} else if (ch == ')') {
					//左括号只弹出并不输出
					Character pop = stack.peek();
					while (pop != '(') {
						//非左括号
						Character pop1 = stack.pop();
						list.add(String.valueOf(pop1));
						pop = stack.peek();
					}
					//此时再把“（”pop出去
					stack.pop();
					
					//如果是操作符 +-*//
				} else {
					if (stack.empty()) {
						stack.push(ch);
					} else {
						while (!stack.empty()) {
							if (stack.peek() == '(') {
								break;
							}
							//如果优先级更大
							if (priority(ch) > priority(stack.peek())) {
								break;
							} else {
								Character pop = stack.pop();
								list.add(String.valueOf(pop));
							}
						}
						stack.push(ch);
					}
				}
			} else {
				String temp = String.valueOf(ch);
				//判断下一位是不是操作数，否则继续拼接
				i++;
				while (!isOpr(chars[i])) {
					temp += ch;
					i++;
				}
				list.add(temp);
				//builder.append(ch);
			}
			//打印出入栈过程
			//System.out.println(builder.toString());
		}
		while (!stack.empty()) {
			list.add(String.valueOf(stack.pop()));
		}
		//System.out.println(builder.toString());
		
		return list;
		
	}
	
	
	/**
	 *  将中缀表达式的list转为逆波兰list
	 * @param list {7 * 2 * ( 19 - 5 ) + 1 - 5}
	 * @return
	 */
	public List<String> toPolandExpression3(List<String> list){
		
		Stack<String> stack = new Stack<>();
		
		int length = list.size();
		List<String> res = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			String ch = list.get(i);
			//是操作符，入栈
			if (isOpr(ch.charAt(0))) {
				//左括号
				if (ch.charAt(0) == '(') {
					stack.push(ch);
					//如果是右括号
				} else if (ch.charAt(0) == ')') {
					//左括号只弹出并不输出
					String pop = stack.peek();
					while (pop.charAt(0) != '(') {
						//非左括号
						String pop1 = stack.pop();
						res.add(pop1);
						pop = stack.peek();
					}
					//此时再把“（”pop出去
					stack.pop();
					
					//如果是操作符 +-*//
				} else {
					if (stack.empty()) {
						stack.push(ch);
					} else {
						while (!stack.empty()) {
							if (stack.peek().charAt(0) == '(') {
								break;
							}
							//如果优先级更大
							if (priority(ch.charAt(0)) > priority(stack.peek().charAt(0))) {
								break;
							} else {
								String pop = stack.pop();
								res.add(pop);
							}
						}
						stack.push(ch);
					}
				}
			} else {
				
				res.add(ch);
				
			}
		}
		while (!stack.empty()) {
			res.add(stack.pop());
		}
		
		
		return res;
		
	}
	
	
	public List<String> toPolandExpression4(List<String> list) {
		Stack<String> stack = new Stack<>();
		List<String> res = new ArrayList<>();
		for (String item : list) {
			if (item.matches("\\d+")) {
				res.add(item);
			} else if (item.equals("(")) {
				stack.push(item);
			} else if (item.equals(")")) {
				while (!stack.empty() && !stack.peek().equals("(")) {
					res.add(stack.pop());
				}
				stack.pop();
			} else {//栈内操作符优先级更大
				while (!stack.empty() && priority(stack.peek().charAt(0)) >= priority(item.charAt(0))) {
					res.add(stack.pop());
				}
				stack.push(item);
			}
		}
		
		if (!stack.empty()) {
			res.add(stack.pop());
		}
			return res;
		
	}
	public boolean isOpr(char ch) {
		String oprString = "+-*/()";
		return oprString.indexOf(ch) > -1;
	}
	
	public int priority(int opr) {
		if (opr == '*' || opr == '/') {
			return 2;
		} else if (opr == '+' || opr == '-') {
			return 1;
		} else {
			return -1;
		}
	}
	
	/**
	 * 只能计算一位数
	 *
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
	
	/**
	 * 可以处理负数  item.length() >= 2
	 *
	 * @param strs
	 * @return
	 */
	public static int cal(String[] strs) {
		int num1, num2, res;
		Stack<String> stack = new Stack<>();
		for (String item : strs) {
			//使用正则表达式，判断是不是数
			if (item.matches("\\d+") || item.length() >= 2) {
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
	
	/**
	 * 将表达式转为list
	 * <p>
	 * "7*2*(19-5)+1-5"   [7 * 2 * ( 19 - 5 ) + 1 - 5]
	 *
	 * @param string
	 * @return
	 */
	public static List<String> toStringList(String string) {
		List<String> list = new ArrayList<>();
		int i = 0;
		String str;
		char ch;
		do {
			if ((ch = string.charAt(i)) < 48 || (ch = string.charAt(i)) > 57) {
				list.add(String.valueOf(ch));
				//后移
				i++;
			} else {
				str = "";
				//多位数考虑拼接
				while (i < string.length() && (ch = string.charAt(i)) >= 48 && (ch = string.charAt(i)) <= 57) {
					str += ch;
					i++;
				}
				
				list.add(String.valueOf(str));
				
			}
		} while (i < string.length());
		
		return list;
		
	}
	
	
	/**
	 * 只能计算一位数
	 *
	 * @param string
	 * @return
	 */
	public static List getList(String string) {
		List<String> list = new ArrayList<>();
		
		char[] chars = string.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			list.add(chars[i] + "");
		}
		
		return list;
	}
	
	/**
	 * 去空格
	 *
	 * @param string
	 * @return
	 */
	public static String toTrim(String string) {
		String s = "";
		char[] chars = string.toCharArray();
		for (char c : chars) {
			if (c != ' ') {
				s += c;
			}
		}
		
		return s;
	}
	
}

