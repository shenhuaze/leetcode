package com.huaze.shen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2019-10-27
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        restore(results, s, "", 4);
        return results;
    }

    private void restore(List<String> results, String remain, String result, int k) {
        if (k == 0) {
            if (remain.isEmpty()) {
                results.add(result);
            }
        } else {
            for (int i = 1; i <= 3; i++) {
                if (remain.length() >= i && isValid(remain.substring(0, i))) {
                    if (k == 1) {
                        restore(results, remain.substring(i), result + remain.substring(0, i), k - 1);
                    } else {
                        restore(results, remain.substring(i), result + remain.substring(0, i) + ".", k - 1);
                    }
                }
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        int i = Integer.valueOf(s);
        return i >= 0 && i < 256;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> results = new RestoreIpAddresses().restoreIpAddresses(s);
        for (String result: results) {
            System.out.println(result);
        }
    }
}
