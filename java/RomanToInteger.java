package com.huaze.shen;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Huaze Shen
 * @date 2019-06-28
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                num += map.get(s.charAt(i));
            } else if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                num += map.get(s.charAt(i));
            } else {
                num -= map.get(s.charAt(i));
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new RomanToInteger().romanToInt(s));
    }
}
