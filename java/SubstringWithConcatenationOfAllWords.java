package com.huaze.shen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Huaze Shen
 * @date 2019-07-11
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return result;
        }
        if (words == null || words.length == 0) {
            return result;
        }
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word :words) {
            if (!wordCount.containsKey(word)) {
                wordCount.put(word, 0);
            }
            wordCount.put(word, wordCount.get(word) + 1);
        }
        int numWords = words.length;
        int wordLength = words[0].length();
        for (int i = 0; i <= s.length() - numWords * wordLength; i++) {
            Map<String, Integer> tempWordCount = new HashMap<>();
            int j = 0;
            while (j < numWords) {
                String tempWord = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                if (!wordCount.containsKey(tempWord)) {
                    break;
                }
                if (!tempWordCount.containsKey(tempWord)) {
                    tempWordCount.put(tempWord, 0);
                }
                tempWordCount.put(tempWord, tempWordCount.get(tempWord) + 1);
                if (tempWordCount.get(tempWord) > wordCount.get(tempWord)) {
                    break;
                }
                j += 1;
            }
            if (j == numWords) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(s, words));
    }
}
