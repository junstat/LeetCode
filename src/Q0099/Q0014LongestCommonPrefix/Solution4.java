package Q0099.Q0014LongestCommonPrefix;

/*
   方法四: 二分查找
   显然，最长公共前缀的长度不会超过字符串数组中的最短字符串的长度。用minLength表示字符串数组中的最短字符串的长度，则可以在[0, minLength]
   的范围内通过二分查找得到最长公共前缀的长度。每次取查找范围的中间值mid,判断每个字符串的长度为mid的前缀是否相同，如果相同则最长公共前缀的长度
   一定大于或等于mid，如果不相同则最长公共前缀的长度一定小于mid，通过上述方式将查找范围缩小一半，直到得到最长公共前缀的长度。
 */
public class Solution4 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) minLength = Math.min(minLength, str.length());

        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) low = mid;
            else high = mid - 1;
        }
        return strs[0].substring(0, low);
    }

    private boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) return false;
            }
        }
        return true;
    }
}
