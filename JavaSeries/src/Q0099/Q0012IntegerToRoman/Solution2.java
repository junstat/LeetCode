package Q0099.Q0012IntegerToRoman;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/*
  执行用时：5 ms, 在所有 Java 提交中击败了87.97%的用户
  内存消耗：37.6 MB, 在所有 Java 提交中击败了86.53%的用户
 */
public class Solution2 {

    @Test
    public void test1() {
        int num = 1994;
        assertEquals(intToRoman(num), "MCMXCIV");
    }

    public String intToRoman(int num) {
        if (num < 1 || num > 3999) return "";

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        StringBuilder result = new StringBuilder();

        while (num > 0) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(roman[i]);
            }
            i++;
        }
        return result.toString();
    }
}