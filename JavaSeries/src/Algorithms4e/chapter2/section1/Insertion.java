package Algorithms4e.chapter2.section1;

import org.junit.Test;

import static Algorithms4e.util.ArrayUtil.*;

public class Insertion {

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
        for (int i = 1; i < n; i++) {
            // 将a[i] 插入到 a[i-1]、a[i-2]、a[i-3]...之中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exchange(a, j, j - 1);
        }
    }
}
