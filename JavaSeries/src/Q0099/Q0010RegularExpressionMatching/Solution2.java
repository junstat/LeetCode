package Q0099.Q0010RegularExpressionMatching;

public class Solution2 {
    int[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new int[s.length() + 1][p.length() + 1];
        return dp(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    public boolean dp(char[] s, int i, char[] p, int j) {
        //memo is 1 means true, else means false;
        // if(i == s.length) return j == p.length;
        if (j == p.length) return i == s.length;
        if (memo[i][j] != 0) return memo[i][j] == 1;
        boolean first = i < s.length && (p[j] == s[i] || p[j] == '.');
        boolean ans = false;
        if (j <= p.length - 2 && p[j + 1] == '*') {
            ans = dp(s, i, p, j + 2) || (first && dp(s, i + 1, p, j));
        } else {
            ans = first && dp(s, i + 1, p, j + 1);
        }
        if (ans) {
            memo[i][j] = 1;
        } else {
            memo[i][j] = 2;
        }
        return ans;
    }
}