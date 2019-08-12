package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-08-10
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null ||s.trim().length() == 0) {
            return 0;
        }
        String[] sSplit = s.split(" +");
        return sSplit[sSplit.length - 1].length();
    }

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
    }
}
