package Algorithms4e.chapter2.section1;

import org.junit.Test;

import static Algorithms4e.util.ArrayUtil.*;

public class Selection {

    @Test
    public void test() {
        String[] a = {"bed", "bug", "dad", "yes", "zoo", "...", "all", "bad", "yet"};
        sort(a);
        assert isSorted(a);
        show(a);
    }

    public static void sort(Comparable[] a) {
        // 将a[]按升序排列
        int n = a.length;

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++)
                if (less(a[j], a[min])) min = j;
            exchange(a, i, min);
        }
    }
}
