package com.huaze.shen;

import java.util.*;

/**
 * @author Huaze Shen
 * @date 2019-07-25
 */
public class GroupAnagrams {
    /**
     * Solution 1
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return results;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newStr = new String(chars);
            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList<>());
            }
            map.get(newStr).add(str);
        }
        for (String key : map.keySet()) {
            results.add(map.get(key));
        }
        return results;
    }

    /**
     * Solution 2
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return results;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            int[] letter_count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                letter_count[str.charAt(i) - 'a'] += 1;
            }
            String key = Arrays.toString(letter_count);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            results.add(map.get(key));
        }
        return results;
    }

    public static void main(String[] args) {
        //String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = {"hos","boo","nay","deb","wow","bop","bob","brr","hey","rye","eve","elf","pup","bum","iva",
                "lyx","yap","ugh","hem","rod","aha","nam","gap","yea","doc","pen","job","dis","max","oho","jed","lye",
                "ram","pup","qua","ugh","mir","nap","deb","hog","let","gym","bye","lon","aft","eel","sol","jab"};
        List<List<String>> results = new GroupAnagrams().groupAnagrams(strs);
        //List<List<String>> results = new GroupAnagrams().groupAnagrams2(strs);
        for (List<String> each : results) {
            System.out.println(each);
        }
    }
}
