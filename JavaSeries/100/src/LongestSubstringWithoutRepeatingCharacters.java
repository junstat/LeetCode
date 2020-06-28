import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "pwwkew";
        int res = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring3(s);
        System.out.println(res);
    }

    /**
     * 滑动窗口：在窗口中始终保存不重复的字母，求窗口的长度并更新到结果中
     * start: 不重复子串中第1个字符在s中的下标
     * end:   不重复子串中最后一个字符在s中的下标
     * HashMap<Character, Integer> lastOccurred: 保存字符 c 在s中最后一次出现的下标
     * 难点，两处`+1`:
     * - 第30行: lastOccurred中保存的是字符c在s中最后一次出现的下标，所以start应该是c后面一个字符，该+1。
     * - 第33行: 手绘一个数轴，数轴上的两个不同点a, b之间的间隔数为(b - a)，可是，a,b间点的个数为(b - a + 1)。
     * 以`pwwkew`为例
     * index: 0 1 2 3 4 5
     * char:  p w w k e w
     * 满足要求的子串为`wke`，而代码计算出结果选取的是`kew`，此时start = index(k) = 3, end = 5, res = end - start + 1 = 3
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> lastOccurred = new HashMap<>();
        int res = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            if (lastOccurred.containsKey(s.charAt(end))) {
                start = Math.max(start, lastOccurred.get(s.charAt(end)) + 1);
            }
            lastOccurred.put(s.charAt(end), end);
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    /**
     * 使用Set做窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
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

    /**
     * 使用自定义哈希表
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
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
