package Q0099.Q0005LongestPalindromicSubstring;

public class Solution2 {
    private char[] str;
    private int n;
    private int beginIndex, longestLength; // 记录最长回文子串的起始位置与长度。

    public String longestPalindrome(String s) {
        str = s.toCharArray();
        n = str.length;
        expansionCenter(n >> 1, 0);
        return new String(str, beginIndex, longestLength);
    }

    // 以 str[index] 为中心进行扩展。
    private void expansionCenter(int index, int direction) {
        int i = index - 1, j = index + 1;
        while (i >= 0 && str[i] == str[index]) {
            i--;
        }
        while (j < n && str[j] == str[index]) {
            j++;
        }
        // 此时 str(i, j) 是一段连续且相同的字符，以 s(i, j) 为中心进行扩展。
        int left = i, right = j;
        while (left >= 0 && right < n && str[left] == str[right]) {
            left--;
            right++;
        }
        if (right - left - 1 > longestLength) {
            beginIndex = left + 1;
            longestLength = right - left - 1;
        }
        if (direction <= 0 && i << 1 > longestLength) {
            expansionCenter(i, -1); // 当前搜索方向向左。
        }
        if (direction >= 0 && n - j << 1 > longestLength) {
            expansionCenter(j, 1); // 当前搜索方向向右。
        }
    }
}
