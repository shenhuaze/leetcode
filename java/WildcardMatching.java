package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-22
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int iStar = -1;
        int jStar = -1;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                i += 1;
                j += 1;
            } else if (j < p.length() && p.charAt(j) == '*') {
                iStar = i;
                jStar = j;
                j += 1;
            } else if (iStar >= 0) {
                i = iStar + 1;
                j = jStar + 1;
                iStar += 1;
            } else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j += 1;
        }
        return j == p.length();
    }

    public static void main(String[] args) {
        String s = "abcdefgh";
        String p = "a*bcdeffh";
        System.out.println(new WildcardMatching().isMatch(s, p));
    }
}
