package IntroductionToAlgorithms3E.ch06HeapSort;

public class HeapSortTest {

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        // 0 -> 1
        // 1 -> 3
        return i * 2 + 1;
    }

    private int right(int i) {
        // 0 -> 2
        // 1 -> 4
        return (i + 1) * 2;
    }

    private void maxHeapify(int[] A, int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (l <= A.length && A[l] > A[i]) largest = l;
        else largest = i;

    }
}
