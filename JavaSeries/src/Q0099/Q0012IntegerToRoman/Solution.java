package Q0099.Q0012IntegerToRoman;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/*
    执行用时：19 ms, 在所有 Java 提交中击败了5.36%的用户
    内存消耗：39.3 MB, 在所有 Java 提交中击败了5.03%的用户
 */
public class Solution {

    @Test
    public void test1() {
        int num = 1994;
        assertEquals(intToRoman(num), "MCMXCIV");
    }

    public String intToRoman(int num) {
        //            0    1000 2000   3000
        String M[] = {"", "M", "MM", "MMM"};
        //            0    100  200   300   400   500  600    700    800     900
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        //            0    10   20    30     40    50   60    70      80     90
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        //            0    1    2     3      4     5    6     7      8      9
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }
}