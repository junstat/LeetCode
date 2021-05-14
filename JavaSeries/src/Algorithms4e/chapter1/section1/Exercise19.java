package Algorithms4e.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/*
   1.1.19 Run the following program on your computer:

   What is the largest value of N for which this program takes less 1 hour to computer the value of F(N)? Develop a
   better implementation of F(N) that saves computed values in an array.
 */
public class Exercise19 {
    public static void main(String[] args) {
        // for (int n = 0; n < 90; n++)
        //     StdOut.println(n + " - " + F(n));

        for (int n = 0; n < 90; n++) {
            int[] arr;
            if (n == 0 || n == 1) arr = new int[2];
            else arr = new int[n + 1];

            arr[0] = 0;
            arr[1] = 1;

            StdOut.println(n + " - " + enhancedF(n, arr));
        }
    }

    private static int enhancedF(int n, int[] arr) {
        for (int i = 2; i <= n; i++) arr[i] = arr[i - 2] + arr[i - 1];
        return arr[n];
    }

    private static int F(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return F(n - 1) + F(n - 2);
    }
}
