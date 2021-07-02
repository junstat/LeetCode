package Algorithms4e.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/*
   1.1.6 What does the following program print?
 */
public class Exercise06 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;

        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
