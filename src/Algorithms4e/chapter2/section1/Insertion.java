package Algorithms4e.chapter2.section1;

/******************************************************************************
 *  Compilation:  javac Insertion.java
 *  Execution:    java Insertion < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   https://algs4.cs.princeton.edu/21elementary/tiny.txt
 *                https://algs4.cs.princeton.edu/21elementary/words3.txt
 *
 *  Sorts a sequence of strings from standard input using insertion sort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Insertion < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java Insertion < words3.txt
 *  all bad bed bug dad ... yes yet zoo   [ one string per line ]
 *
 ******************************************************************************/

import Algorithms4e.chapter2.base.BaseSort;
import edu.princeton.cs.algs4.StdIn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;

/**
 * The {@code Insertion} class provides static methods for sorting an
 * array using insertion sort.
 * <p>
 * In the worst case, this implementation makes ~ &frac12; <em>n</em><sup>2</sup>
 * compares and ~ &frac12; <em>n</em><sup>2</sup> exchanges to sort an array
 * of length <em>n</em>. So, it is not suitable for sorting large arbitrary
 * arrays. More precisely, the number of exchanges is exactly equal to the
 * number of inversions. So, for example, it sorts a partially-sorted array
 * in linear time.
 * <p>
 * This sorting algorithm is stable.
 * It uses &Theta;(1) extra memory (not including the input array).
 * <p>
 * See <a href="https://algs4.cs.princeton.edu/21elementary/InsertionPedantic.java.html">InsertionPedantic.java</a>
 * for a version that eliminates the compiler warning.
 * <p>
 * For additional documentation, see <a href="https://algs4.cs.princeton.edu/21elementary">Section 2.1</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
class Insertion extends BaseSort {
    // This class should not be instantiated.
    private Insertion() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    /**
     * Rearranges the subarray a[lo..hi) in ascending order, using the natural order.
     *
     * @param a  the array to be sorted
     * @param lo left endpoint (inclusive)
     * @param hi right endpoint (exclusive)
     */
    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
        assert isSorted(a, lo, hi);
    }

    /**
     * Rearranges the array in ascending order, using a comparator.
     *
     * @param a          the array
     * @param comparator the comparator specifying the order
     */
    public static void sort(Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1], comparator); j--) {
                exch(a, j, j - 1);
            }
            assert isSorted(a, 0, i, comparator);
        }
        assert isSorted(a, comparator);
    }

    /**
     * Rearranges the subarray a[lo..hi) in ascending order, using a comparator.
     *
     * @param a          the array
     * @param lo         left endpoint (inclusive)
     * @param hi         right endpoint (exclusive)
     * @param comparator the comparator specifying the order
     */
    public static void sort(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], comparator); j--) {
                exch(a, j, j - 1);
            }
        }
        assert isSorted(a, lo, hi, comparator);
    }


    // return a permutation that gives the elements in a[] in ascending order
    // do not change the original array a[]

    /**
     * Returns a permutation that gives the elements in the array in ascending order.
     *
     * @param a the array
     * @return a permutation {@code p[]} such that {@code a[p[0]]}, {@code a[p[1]]},
     * ..., {@code a[p[n-1]]} are in ascending order
     */
    public static int[] indexSort(Comparable[] a) {
        int n = a.length;
        int[] index = new int[n];
        for (int i = 0; i < n; i++)
            index[i] = i;

        for (int i = 1; i < n; i++)
            for (int j = i; j > 0 && less(a[index[j]], a[index[j - 1]]); j--)
                exch(index, j, j - 1);

        return index;
    }

    /**
     * Reads in a sequence of strings from standard input; insertion sorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        String inputFilePath = "/Users/jun/Documents/Learn/LeetCode/src/Algorithms4e/data/tiny.txt";
        FileInputStream fis = new FileInputStream(inputFilePath);
        System.setIn(fis);
        String[] a = StdIn.readAllStrings();
        Insertion.sort(a);
        show(a);
    }
}