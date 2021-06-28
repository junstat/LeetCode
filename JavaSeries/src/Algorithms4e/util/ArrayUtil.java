package Algorithms4e.util;

import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings("unchecked")
public class ArrayUtil {

    public static boolean less(Comparable value1, Comparable value2) {
        return value1.compareTo(value2) < 0;
    }

    public static boolean more(Comparable value1, Comparable value2) {
        return value1.compareTo(value2) > 0;
    }

    public static void exchange(Comparable[] array, int position1, int position2) {
        Comparable temp = array[position1];
        array[position1] = array[position2];
        array[position2] = temp;
    }

    public static void show(Comparable[] a) {
        // 在单行中打印数组
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (more(array[i], array[i + 1])) {
                return false;
            }
        }
        return true;
    }
}
