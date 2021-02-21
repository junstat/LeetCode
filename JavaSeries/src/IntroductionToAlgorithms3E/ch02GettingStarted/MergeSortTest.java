package IntroductionToAlgorithms3E.ch02GettingStarted;

import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {

    @Test
    public void test() {
        int[] nums = {2, 4, 56, 1, 39};
        System.out.println(Arrays.toString(nums));
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void mergeSort(int[] A) {
        mergeSort(A, 0, A.length - 1);
    }

    private void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = p + (r - p) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            // mergeBySentinels(A, p, q, r);
            merge(A, p, q, r);
        }
    }

    /*
        MERGE(A, p, q, r)
        n1 = q - p + 1
        n2 = r - q
        let L[1..n1] and R[1..n2] be new arrays
        for i = 1 to n1
            L[i] = A[p + i - 1]
        for j = 1 to n2
            R[j] = A[q + j]
        i = 1
        j = 1
        for k = p to r
            if i > n1
                A[k] = R[j]
                j = j + 1
            else if j > n2
                A[k] = L[i]
                i = i + 1
            else if L[i] ≤ R[j]
                A[k] = L[i]
                i = i + 1
            else
                A[k] = R[j]
                j = j + 1
     */
    private void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1], R = new int[n2 + 1];
        for (int i = 0; i < n1; i++) L[i] = A[p + i];
        for (int j = 0; j < n2; j++) R[j] = A[q + j + 1];
        for (int i = 0, j = 0, k = p; k <= r; k++)
            if (i >= n1) A[k] = R[j++];
            else if (j >= n2) A[k] = L[i++];
            else if (L[i] <= R[j]) A[k] = L[i++];
            else A[k] = R[j++];
    }


    /*
       Merge(A, p, q, r)
          n1 = q - p + 1;
          n2 = r -q;
          let L[1, ..., n1+1] and R[1, ... , n2+1] be new arrays
          for i = 1 to n1
              L[i] = A[p + i -1]
          for j = 1 to n2
              R[j] = A[q+j]
          L[n1+1] = inf
          R[n2+1] = inf
          i = 1
          j = 1
          for k = p to r
              if L[i] <= R[j]
                  A[k] = L[i]
                  i = i + 1
              else
                  A[k] = R[j]
                  j = j + 1
     */
    private void mergeBySentinels(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1], R = new int[n2 + 1];
        for (int i = 0; i < n1; i++) L[i] = A[p + i];
        for (int j = 0; j < n2; j++) R[j] = A[q + j + 1];
        L[n1] = R[n2] = Integer.MAX_VALUE;
        for (int i = 0, j = 0, k = p; k <= r; k++)
            if (L[i] <= R[j]) A[k] = L[i++];
            else A[k] = R[j++];

    }
}