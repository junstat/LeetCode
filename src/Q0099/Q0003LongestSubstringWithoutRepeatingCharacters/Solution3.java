package Q0099.Q0003LongestSubstringWithoutRepeatingCharacters;

public class Solution3 {
    /**
     * 使用自定义哈希表
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int[] lastOccurred = new int[128];
        int res = 0;

        for (int start = 0, end = 0; end < s.length(); end++) {
            if (lastOccurred[s.charAt(end)] >= start) {
                start = lastOccurred[s.charAt(end)];
            }
            res = Math.max(res, end - start + 1);
            lastOccurred[s.charAt(end)] = end + 1;
        }
        return res;
    }
}
