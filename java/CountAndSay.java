package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-17
 */
public class CountAndSay {
    /**
     * Solution 1
     */
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        result.append("1");
        for (int i = 1; i < n; i++) {
            String temp = result.toString();
            result = new StringBuilder();
            int j = 0;
            while (j < temp.length()) {
                char ch = temp.charAt(j);
                int count = 0;
                for (int k = j; k < temp.length(); k++) {
                    if (ch != temp.charAt(k)) {
                        break;
                    }
                    count += 1;
                }
                result.append(count);
                result.append(ch);
                j += count;

            }
        }
        return result.toString();
    }

    /**
     * Solution 2
     */
    public String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        } else {
            return generateNextSequence(countAndSay2(n - 1));
        }
    }

    private String generateNextSequence(String currentSequence) {
        StringBuilder nextSequence = new StringBuilder();
        int i = 0;
        while (i < currentSequence.length()) {
            char currChar = currentSequence.charAt(i);
            int j = i + 1;
            while (j < currentSequence.length()) {
                if (currentSequence.charAt(j) != currChar) {
                    break;
                }
                j += 1;
            }
            nextSequence.append(j - i);
            nextSequence.append(currChar);
            i += j - i;
        }
        return nextSequence.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4));
        System.out.println(new CountAndSay().countAndSay2(4));
    }
}
