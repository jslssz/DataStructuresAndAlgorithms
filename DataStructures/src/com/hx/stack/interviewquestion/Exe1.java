package com.hx.stack.interviewquestion;

import java.util.Stack;

/**
 *
 * 括号匹配
 * @author jxlgcmh
 * @create 2019-06-14 11:18
 */
public class Exe1 {
	public static void main(String[] args) {
		String s ="({}({}))}{";
		System.out.println(isProper(s));
	}
	
	public static boolean isProper(String s){
		
		Stack<String> stack =new Stack<>();
		int length = s.length();
		if (length % 2 !=0){
			return false;
		}
		for (int i = 0; i < length; i++) {
			String temp = String.valueOf(s.charAt(i));
			if (temp.equals("(") || temp.equals("[") ||temp.equals("{")){
				stack.push(temp);
			}else {
				if (! stack.empty()&&! (temp.equals(")") && stack.pop().equals("(")) && ! (temp.equals("]") && stack.pop().equals("[")) && ! (temp.equals("}") && stack.pop().equals("{"))){
					return false;
				}
			}
			
		}
		return stack.empty();
	}
}
