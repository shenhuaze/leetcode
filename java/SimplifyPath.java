package com.huaze.shen;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Huaze Shen
 * @date 2019-09-17
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        for (String s: split) {
            if (s.isEmpty() || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        List<String> result = new ArrayList<>(stack);
        return "/" + String.join("/", result);
    }

    public static void main(String[] args) {
        //String path = "/a//b////c/d//././/..";
        String path = "/a/../../b/../c//.//";
        System.out.println(new SimplifyPath().simplifyPath(path));
    }
}
