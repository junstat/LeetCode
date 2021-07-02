package Q0099.Q0065ValidNumber;

import org.junit.Test;

public class Solution1 {

    @Test
    public void test1() {
        String s = "005047e+6";
        System.out.println(isNumber(s));
    }

    @Test
    public void test2() {
        String s = "1E9";
        System.out.println(isNumber(s));
    }

    public boolean isNumber(String s) {
        return s.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*([e|E][-+]?\\d+)?");
    }
}
