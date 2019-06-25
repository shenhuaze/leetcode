package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-06-25
 *
 * 正则字符串匹配
 * "."匹配任一字符，"*"表示之前那个字符可以有0个，1个或是多个
 *
 * 思路一：分类递归
 * 最直观的做法就是根据s和p的情况进行分类匹配，
 * 然后递归判断，每次递归视情况匹配p的前1或2个字符。
 * 为使分类清晰，这里根据p字符串的长度进行分类
 * 1.当p.length = 0，返回s.isEmpty()
 * 2.当p.length = 1(说明没有*)，判断s时候也是长度为1且当前字符能够匹配
 * 3.当p.length > 1，且p[1] != "*"(不含"*"的情况)
 *   若s为空，返回false，否则就是单一字符进行匹配,递归判断s和p的下一个字符
 * 4.当p.length > 1，且p[1] = "*"(含"*"的情况)，
 *   则应该把可能重复的s字符逐一匹配然后去掉，使用一个循环，
 *   由于"*"的特性，要考虑到当前p的前两个字符可能匹配不到任何的s，
 *   所以要先判断下isMatch(s, p.substring(2))
 *   即当前p的前两个字符不进行任何匹配。
 *   然后再是逐一判断s[0]与p[0]是否相等，是则s取下一字符，否则结束循环。
 *   循环结束后，说明p的前两个字符已经匹配完毕，p取后面的字符
 *
 * 思路二：动态规划
 * 关键是状态转移方程
 * p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1]
 * If p.charAt(j) == ‘.’ : dp[i][j] = dp[i-1][j-1];
 *
 * If p.charAt(j) == ‘*’:
 * here are two sub conditions:
 *   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2] //in this case, a* only counts as empty
 *   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == ‘.’:
 *       dp[i][j] = dp[i-1][j] // in this case, a* counts as multiple a
 *       dp[i][j] = dp[i][j-1] // in this case, a* counts as single a
 *       dp[i][j] = dp[i][j-2] // in this case, a* counts as empty
 * 示例
 * s\p ""  a  *  b  *
 * ""   1  0  1  0  1
 *  a   0  1  1  0  1
 *  a   0  0  1  0  1
 *  a   0  0  1  0  1
 *  a   0  0  1  0  1
 **/
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        //return isMatchRecursion(s, p);
        return isMatchDp(s, p);
    }

    private static boolean isMatchRecursion(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        } else if (p.length() == 1) {
            return s.length() == 1 && (p.equals(s) || p.equals("."));
        } else if (p.charAt(1) != '*') {
            if (s.isEmpty()) {
                return false;
            }
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                    && isMatchRecursion(s.substring(1, s.length()), p.substring(1, p.length()));
        } else {
            while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatchRecursion(s, p.substring(2, p.length()))) {
                    return true;
                }
                s = s.substring(1, s.length());
            }
        }
        return isMatchRecursion(s, p.substring(2, p.length()));
    }

    private static boolean isMatchDp(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // 初始化第一行，p匹配s = ""
        for (int i = 1; i < n; i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // p[j - 1]不是"*"的情况，单字符匹配
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // p[j - 1]是"*"的情况，则要判断p[j - 2]是否匹配当前s[i - 1]
                // 若不匹配，则p[j - 1]匹配空字符串
                // 否则，有三种情况：
                //   1.p[j - 1]匹配空字符串；
                //   2.p[j - 1]匹配单一s[i - 1]字符；
                //   3.p[j - 1]匹配多个s[i - 1]字符
                if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "aa";
        String a = "a*";
        boolean match = new RegularExpressionMatching().isMatch(s, a);
        System.out.println(match);
    }
}
