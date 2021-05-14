package Algorithms4e.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/*
   1.1.14 Write a static method lg() that takes an int value N as argument and returns the largest int not larger than
   the base-2 logarithm of N. Do not use Math.
 */
public class Exercise14 {
    public static void main(String[] args) {
        StdOut.println(lg(15));
        StdOut.println("\nExpected: 3");
    }

    private static int lg(int n) {
        int logInt = 0;
        while (n > 0) {
            logInt++;
            n /= 2;
        }
        return logInt - 1;
    }
}
