package Q0099.Q0029DivideTwoIntegers;

/*
   思路:
       商 x 除数 + 余数 = 被除数
    可以把一个dividend（被除数）先除以2^n，n最初为31，不断减小n去试探,当某个n满足dividend/2^n>=divisor时，
    表示我们找到了一个足够大的数，这个数*divisor是不大于dividend的，所以我们就可以减去2^n个divisor，以此类推
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean negative;
        negative = (dividend ^ divisor) < 0;   // 用异或来计算是否符号相异
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((t >> i) >= d) {
                result += 1 << i;
                t -= d << i;
            }
        }
        return negative ? -result : result;   // 符号相异取反
    }
}
