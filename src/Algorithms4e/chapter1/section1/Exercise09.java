package Algorithms4e.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/*
   1.1.9 Write a code fragment that puts the binary representation of a positive integer N into a String S.
   Solution: Java has a built-in method Integer.toBinaryString(N) for this job, but the point of the exercise is to see
   how such a method might be implemented.
 */
public class Exercise09 {
    public static void main(String[] args) {
        StdOut.println(intToBinary(32));
        StdOut.println("Expected: 100000");
    }

    private static String intToBinary(int n) {
        String result = "";
        while (n > 0) {
            result = n % 2 + result;
            n /= 2;
        }
        return result;
    }
}
