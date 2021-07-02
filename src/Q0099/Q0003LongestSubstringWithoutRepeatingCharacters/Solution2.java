package Q0099.Q0003LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    /**
     * 使用Set做窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> window = new HashSet<>();
        int res = 0, start = 0, end = 0;
        while (start < n && end < n) {
            // try to extend the range [i, j]
            if (!window.contains(s.charAt(end))) {
                window.add(s.charAt(end++));
                res = Math.max(res, window.size());  // window.size() <==> end - start, 这里为什么不+1了呢？
            } else {
                window.remove(s.charAt(start++));
            }
        }
        return res;
    }
}
