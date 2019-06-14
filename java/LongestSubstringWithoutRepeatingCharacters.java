package com.huaze.shen;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Huaze Shen
 * @date 2019-06-14
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charPositions = new HashMap<>();
        int left = -1;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (charPositions.containsKey(ch) && (charPositions.get(ch) > left)) {
                left = charPositions.get(ch);
            }
            charPositions.put(ch, i);
            maxLen = Math.max(maxLen, i - left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        //String s = "abcabcbb";
        //String s = "abba";
        String s = "aab";
        int maxLen = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
        System.out.println(maxLen);
    }
}
