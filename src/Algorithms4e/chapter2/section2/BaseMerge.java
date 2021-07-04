package Algorithms4e.chapter2.section2;

import Algorithms4e.chapter2.base.BaseSort;

public class BaseMerge extends BaseSort {
    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // 2.2.1 原地归并的抽象方法
        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        // copy to aux[]
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        // merge back to a[]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];           // 左边部分没有元素了
            else if (j > hi) a[k] = aux[i++];       // 右边部分没有元素了
            else if (less(aux[j], aux[i])) a[k] = aux[j++];     // 右边小
            else a[k] = aux[i++];                               // 左边小
        }

        // postcondition: a[lo ... hi] is sorted
        assert isSorted(a, lo, hi);
    }
}
