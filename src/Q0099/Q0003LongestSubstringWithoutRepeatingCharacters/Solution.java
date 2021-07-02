package Q0099.Q0003LongestSubstringWithoutRepeatingCharacters;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class Solution {

    @Test
    public void test1() {
        String s = "pwwkew";
        assertEquals(lengthOfLongestSubstring(s), 3);
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
}
