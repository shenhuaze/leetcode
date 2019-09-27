package com.huaze.shen;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Huaze Shen
 * @date 2019-09-24
 */
public class MinimumWindowSubstring {
    /**
     * Solution 1
     */
    public String minWindow(String s, String t) {
        String result = "";
        Map<Character, Integer> letterCount = new HashMap<>();
        int left = 0;
        int count = 0;
        int minLen = s.length();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!letterCount.containsKey(ch)) {
                letterCount.put(ch, 0);
            }
            letterCount.put(ch, letterCount.get(ch) + 1);
        }
        for (int right = 0; right < s.length(); right++) {
            char rightCh = s.charAt(right);
            if (letterCount.containsKey(rightCh)) {
                letterCount.put(rightCh, letterCount.get(rightCh) - 1);
                if (letterCount.get(rightCh) >= 0) {
                    count += 1;
                }
            }
            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                char leftCh = s.charAt(left);
                if (letterCount.containsKey(leftCh)) {
                    letterCount.put(leftCh, letterCount.get(leftCh) + 1);
                    if (letterCount.get(leftCh) > 0) {
                        count -= 1;
                    }
                }
                left += 1;
            }
        }
        return result;
    }

    /**
     * Solution 2
     */
    public String minWindow2(String s, String t) {
        String result = "";
        int[] letterCount = new int[256];
        int left = 0;
        int count = 0;
        int minLen = s.length() + 1;
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            letterCount[ch] += 1;
        }
        for (int right = 0; right < s.length(); right++) {
            char rightCh = s.charAt(right);
            letterCount[rightCh] -= 1;
            if (letterCount[rightCh] >= 0) {
                count += 1;
            }
            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                char leftCh = s.charAt(left);
                letterCount[leftCh] += 1;
                if (letterCount[leftCh] > 0) {
                    count -= 1;
                }
                left += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //String s = "ABAACBAB";
        String s = "ADOBECODEBANC";
        String t = "ABC";
        //System.out.println(s.charAt(4));
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
        System.out.println(new MinimumWindowSubstring().minWindow2(s, t));
    }
}

