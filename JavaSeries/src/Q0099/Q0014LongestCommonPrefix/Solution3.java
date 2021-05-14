package Q0099.Q0014LongestCommonPrefix;

/*
   方法三: 分治
   注意到LCP的计算满足结合律:
        LCP(S1 ... Sn) = LCP(LCP(S1 ... Sk), LCP(Sk+1, ..., Sn))

   时间复杂度: O(mn)
   空间复杂度: O(m logn)
 */
public class Solution3 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) return strs[start];
        int mid = start + (end - start) / 2;
        String lcpLeft = longestCommonPrefix(strs, start, mid);
        String lcpRight = longestCommonPrefix(strs, mid + 1, end);
        return commonPrefix(lcpLeft, lcpRight);
    }

    private String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }
}
