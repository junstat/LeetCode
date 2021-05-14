package Q0099.Q0091DecodeWays;

/*
   Solution 2: DP
   Time: O(n)
   Space: O(1)

   dp[i]: ways to decode s[0] ... s[i]
   dp[-1] = 1

   dp[i] =
   1: ans = 0,              if s[i], s[i-1]s[i] are invalid
   2: dp[i-1] + dp[i-2],    if s[i], s[i-1]s[i] are valid
   3: dp[i-1],              if s[i] is valid
   4: dp[i-2],              if s[i-1]s[i] is valid

   s[i] is valid            if s[i] != '0'
   s[i-1]s[i] is valid if "10" <= s[i-1]s[i] <= "26"
 */
public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}
