package IntroductionToAlgorithms3E.ch02GettingStarted.Exercises;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
  Referring back to the searching problem (see Exercise 2.1-3), observe that if the sequence AA is sorted, we can check
  the midpoint of the sequence against vv and eliminate half of the sequence from further consideration. The binary
  search algorithm repeats this procedure, halving the size of the remaining portion of the sequence each time.
  Write pseudocode, either iterative or recursive, for binary search. Argue that the worst-case running time of binary
  search is \Theta(\lg n)Θ(lgn).
 */
public class Problem2_3_5 {
    @Test
    public void test() {
        int[] nums = {2, 4, 5, 7, 9, 12};
        int target1 = 4;
        // assertEquals(binarySearchIterative(nums, target1), 1);
        assertEquals(binarySearchRecursive(nums, target1), 1);
        int target2 = 0;
        // assertEquals(binarySearchIterative(nums, target2), -1);
        assertEquals(binarySearchRecursive(nums, target2), -1);
    }

    private int binarySearchRecursive(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return binarySearchRecursive(nums, target, 0, nums.length - 1);
    }

    /*
      RECURSIVE-BINARY-SEARCH(A, v, low, high)
    if low > high
        return NIL
    mid = floor((low + high) / 2)
    if v == A[mid]
        return mid
    else if v > A[mid]
        return RECURSIVE-BINARY-SEARCH(A, v, mid + 1, high)
    else return RECURSIVE-BINARY-SEARCH(A, v, low, mid - 1)
     */
    private int binarySearchRecursive(int[] nums, int target, int low, int high) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (target == nums[mid]) return mid;
        else if (target > nums[mid]) return binarySearchRecursive(nums, target, mid + 1, high);
        else return binarySearchRecursive(nums, target, low, mid - 1);
    }

    /*
      ITERATIVE-BINARY-SEARCH(A, v, low, high)
    while low ≤ high
        mid = floor((low + high) / 2)
        if v == A[mid]
            return mid
        else if v > A[mid]
            low = mid + 1
        else high = mid - 1
    return NIL
     */
    private int binarySearchIterative(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) return mid;
            else if (target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}