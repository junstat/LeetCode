package Q0099.Q0028ImplementStrStr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution {

    @Test
    public void test1() {
        String haystack = "hello", needle = "ll";
        assertEquals(strStr(haystack, needle), 2);
    }

    @Test
    public void test2() {
        String haystack = "aaaaa", needle = "bba";
        assertEquals(strStr(haystack, needle), -1);
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
