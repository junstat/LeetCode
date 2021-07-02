package Q0099.Q0005LongestPalindromicSubstring;

public class Solution {
    /**
     * Dynamic Programming
     * 1. 状态定义
     *    booleam dp[i][j] = s[i, j] is Palindromic
     * 2. 状态初始条件
     *    dp[i][j] = true            if len(s[i, j]) == 1 or j == i or j - i == 0;
     *    dp[i][j] = s[i] == s[j]    if len(s[i, j]) == 2 or j == (i + 1) or j - i == 1;
     * 3. 状态转移方程
     *    dp[i][j] = s[i] == s[j] && dp[i+1][j-1]
     *
     *   判断条件整合：
     *   a. 若: j - i == 0 , 则dp[i][j] = (s[i] == s[j]) 恒为true, 1个字符自然回文
     *   b. 若: j - i == 1 , 则dp[i][j] = s[i] == s[j]   2个字符，首尾相等即可
     *   c. 若: j - i == 2 , 则dp[i][j] = s[i] == s[j]   3个字符，首尾相等即可，中间有1个字符，不打紧
     *   d. 若: j - i > 2  , 则dp[i][j] = s[i] == s[j]  && dp[i + 1][j - 1]   4个字符(含)，首尾相等，外加中间子串为回文才行
     *   a. b. c. 判断条件整合 => s[i] == s[j] && (j - i <= 2)
     *   与d. 合并后 判断条件整合为一个 => s[i] == s[j] && ( (j - i <= 2) || dp[i + 1][j - 1] )
     *
     * time: O(n^2) space: O(n^2)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
                if (dp[i][j] && (j - i + 1 > max)) {
                    max = j - i + 1;
                    res = s.substring(i, j + 1);  // [i, j+1)
                }
            } // end of inner for loop
        } // end of outer for loop
        return res;
    }
}
