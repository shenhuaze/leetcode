package com.huaze.shen;


/**
 * @author Huaze Shen
 * @date 2019-08-23
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }
        String regex = "[-+]?(?:[0-9]+\\.?|\\.[0-9]+)[0-9]*(?:e[-+]?[0-9]+)?";
        return s.trim().matches(regex);
    }

    public static void main(String[] args) {
        String s = "53.5e93";
        System.out.println(new ValidNumber().isNumber(s));
    }
}
