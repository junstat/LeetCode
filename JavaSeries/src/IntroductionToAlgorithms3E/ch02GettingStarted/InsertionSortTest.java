package IntroductionToAlgorithms3E.ch02GettingStarted;

import org.junit.Test;

import java.util.Arrays;

/*
   INSERTION-SORT(A)
   for j = 2 to A.length
      key = A[j]
      // Insert A[j] into the sorted sequence A[1, ... , j -1]
      i = j - 1
      while i > 0 and A[i] > key
            A[i + 1] = A[i]
            i = i - 1
      A[i + 1] = key
 */
public class InsertionSortTest {
    @Test
    public void test() {
        int[] nums = {2, 4, 56, 1, 39};
        System.out.println(Arrays.toString(nums));
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void insertionSort(int[] A) {
        if (A == null || A.length == 0) return;
        for (int j = 1; j < A.length; j++) {
            int key = A[j];
            // Insert A[j] into the sorted sequence A[0 ... j-1].
            int i = j - 1;
            while (i >= 0 && A[i] > key) A[i + 1] = A[i--];
            A[i + 1] = key;
        }
    }
}
