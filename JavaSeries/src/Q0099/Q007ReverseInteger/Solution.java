package Q0099.Q007ReverseInteger;

public class Solution {
    /**
     * reverse 自然想到 Stack，不使用额外的空间，手动模拟：
     * 每次取x的个位顺序放都结果中即可。
     * 使用int保存结果，注意溢出。
     * 来自官方题解
     * @param x
     * @return
     */
    public int reverse(int x) {
//        System.out.println(Integer.MAX_VALUE);  // 2147483647
//        System.out.println(Integer.MIN_VALUE);  // -2147483648
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
