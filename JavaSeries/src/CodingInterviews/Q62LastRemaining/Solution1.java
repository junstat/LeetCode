package CodingInterviews.Q62LastRemaining;

public class Solution1 {
    /*
       创新解法:
         递推公式：f(n,m) = [f(n-1,m)+m]%n，n>1
     */
    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) return -1;

        int last = 0;
        for (int i = 2; i <= n; i++)
            last = (last + m) % i;
        return last;
    }
}
