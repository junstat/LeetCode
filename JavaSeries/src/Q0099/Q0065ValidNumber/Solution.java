package Q0099.Q0065ValidNumber;

import org.junit.Test;

public class Solution {

    @Test
    public void test1() {
        String s = "005047e+6";
        System.out.println(isNumber(s));
    }

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int index = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            index = 1;
        }

        boolean hasDigit = false;
        boolean hasE = false;
        boolean hasDot = false;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                hasDigit = true;
                index++;
                continue;
            }

            switch (s.charAt(index)) {
                case 'e':
                case 'E':
                    if (hasE || !hasDigit || index == s.length() - 1) {
                        return false;
                    }
                    hasE = true;
                    break;
                case '.':
                    if (hasDot || hasE) {
                        return false;
                    }
                    hasDot = true;
                    break;
                case '+':
                case '-':
                    if ((s.charAt(index - 1) != 'e' && s.charAt(index - 1) != 'E') || index == s.length() - 1) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }

            index++;
        }

        return hasDigit;
    }
}
