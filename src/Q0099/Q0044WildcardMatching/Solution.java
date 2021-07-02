package Q0099.Q0044WildcardMatching;

import org.junit.Test;

public class Solution {

    @Test
    public void test1() {
        String s = "adceb", p = "*a*b";
        System.out.println(isMatch(s, p));
    }

    @Test
    public void test2() {
        String s = "acdcb", p = "a*c?b";
        System.out.println(isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, starIndex = -1, iIndex = -1;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++i;
                ++j;
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                iIndex = i;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                i = iIndex + 1;
                iIndex++;
            } else return false;

        }

        while (j < p.length() && p.charAt(j) == '*') ++j;

        return j == p.length();
    }
}
