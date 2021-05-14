package Q0099.Q0031NextPermutation;

/*
   According to Wikipedia, a man named Narayana Pandita presented the following simple algorithm to solve this problem in the 14th century.

    1> Find the largest index k such that nums[k] < nums[k + 1]. If no such index exists, just reverse nums and done.
    2> Find the largest index l > k such that nums[k] < nums[l].
    3> Swap nums[k] and nums[l].
    4> Reverse the sub-array nums[k + 1:].

    The above algorithm can also handle duplicates and thus can be further used to solve Permutations and Permutations II.
    Time: O(n), Space: O(1)
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) return;
        int n = nums.length, k = n - 2, l = n - 1;
        // for (k = n - 2; k >= 0; k--) {
        //     if (nums[k] < nums[k + 1]) break;
        // }
        // if (k < 0) {
        //     reverse(nums, 0, n - 1);
        // } else {
        //     for (l = n - 1; l > k; l--) {
        //         if (nums[l] > nums[k]) break;
        //     }
        //     swap(nums, k, l);
        //     reverse(nums, k + 1, n - 1);
        // }
        while (k >= 0 && nums[k] >= nums[k + 1]) k--;  // Find 1st id k that breaks descending order
        if (k >= 0) {                                  // If not entirely descending
            while (nums[l] <= nums[k]) l--;            // Find rightmost first larger id l
            swap(nums, k, l);                          // swap k and l
        }
        reverse(nums, k + 1, n - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) swap(nums, i, j);
    }
}
