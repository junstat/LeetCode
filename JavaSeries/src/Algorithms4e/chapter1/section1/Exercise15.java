package Algorithms4e.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/*
   1.1.15 Write a static method histogram() that takes an array a[] of int values and an integer M as arguments and
   returns an array of length M whose ith entry is the number of times the integer i appeared in the argument array.
   if the values in a[] are all between 0 and M-1, the sum of the values in the returned array should be equal to a.
   length.
 */
public class Exercise15 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};

        int[] newArrA = histogram(a, 5);

        int[] b = {1, 2, 3, 9};

        int[] newArrB = histogram(b, 7);

        for (int i = 0; i < newArrA.length; i++)
            StdOut.print(newArrA[i] + " ");

        StdOut.println("\nExpected: 0 1 1 1 1");

        StdOut.println();

        for (int i = 0; i < newArrB.length; i++)
            StdOut.print(newArrB[i] + " ");

        StdOut.println("\nExpected: 0 1 1 1 0 0 0");
    }

    private static int[] histogram(int[] a, int m) {
        int[] newArr = new int[m];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < m) newArr[a[i]]++;
        }

        return newArr;
    }
}
