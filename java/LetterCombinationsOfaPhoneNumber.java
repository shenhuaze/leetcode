package com.huaze.shen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2019-07-02
 */
public class LetterCombinationsOfaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return results;
        }
        String[] digitLetter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(results, "", 0, digitLetter, digits);
        return results;
    }

    private void dfs(List<String> results, String prefix, int index, String[] digitLetter, String digits) {
        if (index == digits.length()) {
            results.add(prefix);
            return;
        }
        int digit = Integer.valueOf(digits.substring(index, index + 1));
        String letters = digitLetter[digit];
        for (int i = 0; i < letters.length(); i++) {
            dfs(results, prefix + letters.substring(i, i + 1), index + 1, digitLetter, digits);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(new LetterCombinationsOfaPhoneNumber().letterCombinations(digits));
    }
}
