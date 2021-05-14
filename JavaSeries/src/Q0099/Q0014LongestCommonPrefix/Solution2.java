package Q0099.Q0014LongestCommonPrefix;

/*
   方法二: 纵向扫描
   从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，如果相同则继续对下一列进行比较，如果不相同则当前列不再属于公共前缀，
   当前列之前的部分为最长公共前缀。

   时间复杂度: O(mn)，其中m是字符串数组中的字符串的平均长度，n是字符串的数量。
   空间复杂度: O(1)。
 */
public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
