package Q0099.Q0013RomanToInteger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution {

    @Test
    public void test1() {
        /*
          Input: s = "MCMXCIV"
          Output: 1994
          Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
          以CM = 900为例
          策略: 从右往左遍历，M = 1000, C = 100, 若出现逆序，则作差， CM = 1000 - 100 = 900.
        */
        String s = "MCMXCIV";
        assertEquals(romanToInt(s), 1994);
    }

    public int romanToInt(String s) {
        int res = 0;
        int pre = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = toNumber(s.charAt(i));
            if (cur >= pre) {
                res += cur;
            } else {
                res -= cur;
            }
            pre = cur;
        }
        return res;
    }

    private int toNumber(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}