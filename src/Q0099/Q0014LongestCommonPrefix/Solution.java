package Q0099.Q0014LongestCommonPrefix;

/*
   方法一: 横向扫描
   用LCP(S1, ..., Sn) 表示字符串S1, ..., Sn的最长公共前缀
   可以得到以下结论:
   LCP(S1, ..., Sn) = LCP(LCP(LCP(S1, S2), S3), ... Sn)

   时间复杂度: O(mn)，其中m是字符串数组中的字符串的平均长度，n是字符串的数量。
   空间复杂度: O(1)。
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for (String str : strs) {
            prefix = longestCommonPrefix(prefix, str);
            if (prefix.length() == 0) break;
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) index++;
        return str1.substring(0, index);
    }
}
