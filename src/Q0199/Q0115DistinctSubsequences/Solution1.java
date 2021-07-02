package Q0199.Q0115DistinctSubsequences;

/*
   Notice that we keep the whole m*n matrix simply for dp[i - 1][j - 1]. So we can simply store that value in a single variable and further optimize the space complexity. The final code is as follows.
 */
public class Solution1 {
    public int numDistinct(String s, String t) {
        int m = t.length(), n = s.length();
        int[] cur = new int[m + 1];
        cur[0] = 1;
        for (int j = 1; j <= n; j++) {
            int pre = 1;
            for (int i = 1; i <= m; i++) {
                int temp = cur[i];
                cur[i] = cur[i] + (t.charAt(i - 1) == s.charAt(j - 1) ? pre : 0);
                pre = temp;
            }
        }
        return cur[m];
    }
}
