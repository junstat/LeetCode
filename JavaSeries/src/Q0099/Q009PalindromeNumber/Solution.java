package Q0099.Q009PalindromeNumber;/*
    手动模拟Stack
 */

public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0) ) return false;
        int reverse = 0;
        while (x > reverse) {
            int pop = x % 10;
            x /= 10;
            reverse = reverse * 10 + pop;
        }
        return x == reverse || (reverse / 10) == x;
    }
}
