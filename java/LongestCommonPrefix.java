package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-06-28
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int position = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            String prefix = strs[0].substring(0, i + 1);
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(prefix)) {
                    return strs[0].substring(0, position);
                }
            }
            position = i + 1;
        }
        return strs[0].substring(0, position);
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
