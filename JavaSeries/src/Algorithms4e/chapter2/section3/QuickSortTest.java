package Algorithms4e.chapter2.section3;

import org.junit.Test;

import java.util.Arrays;

public class QuickSortTest {
    @Test
    public void test1() {
        Comparable[] arr = {1, 5, 3, 7, 9};
        System.out.println(Arrays.toString(arr));
        QuickSort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        Comparable[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(arr));
        QuickSort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
