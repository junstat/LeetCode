package IntroductionToAlgorithms3E.ch07Quicksort;

import org.junit.Test;

import java.util.Arrays;

public class QuicksortTest {

    @Test
    public void test() {
        int[] nums = {2, 4, 56, 1, 39};
        System.out.println(Arrays.toString(nums));
        quicksort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void quicksort(int[] A) {
        quicksort(A, 0, A.length - 1);
    }

    private void quicksort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quicksort(A, p, q - 1);
            quicksort(A, q + 1, r);
        }
    }

    private int partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++)
            if (A[j] <= x) exchange(A, ++i, j);
        exchange(A, i + 1, r);
        return i + 1;
    }

    private void exchange(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
