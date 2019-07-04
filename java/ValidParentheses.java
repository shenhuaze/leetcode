package com.huaze.shen;

import java.util.Stack;

/**
 * @author Huaze Shen
 * @date 2019-07-03
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (s.charAt(i) == ')' && stack.peek() != '(') {
                    return false;
                }
                if (s.charAt(i) == ']' && stack.peek() != '[') {
                    return false;
                }
                if (s.charAt(i) == '}' && stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(new ValidParentheses().isValid(s));
    }
}
