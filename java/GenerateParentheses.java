package com.huaze.shen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2019-07-04
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        dfs(results, 0, 0, "", n);
        return results;
    }

    private void dfs(List<String> results, int left, int right, String current, int n) {
        if (left < right) {
            return;
        }
        if (left == n && right == n) {
            results.add(current);
        }
        if (left < n) {
            dfs(results, left + 1, right, current + "(", n);
        }
        if (right < n) {
            dfs(results, left, right + 1, current + ")", n);
        }
    }

    public static void main(String[] args) {
        List<String> results = new GenerateParentheses().generateParenthesis(3);
        System.out.println(results);
    }
}
