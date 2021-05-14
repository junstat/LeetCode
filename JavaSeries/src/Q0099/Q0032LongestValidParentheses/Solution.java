package Q0099.Q0032LongestValidParentheses;

import org.junit.Test;

/*
   思路一: 动态规划
   定义 dp[i] 表示以下标i字符结尾的最长有效括号的长度(init 0)。
    1. s[i] = ')' 且 s[i-1]='(' 即 "....()" => dp[i] = dp[i-2] + 2

    2. s[i] = ')' 且 s[i-1] = ')' 即 "....))" =>
        s[i - dp[i-1] - 1] = '(' 则 dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2

    最后的答案即为 dp 数组中的最大值
 */
public class Solution {

    @Test
    public void test1() {
        String s = "(()";
    }

    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
