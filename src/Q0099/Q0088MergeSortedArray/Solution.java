package Q0099.Q0088MergeSortedArray;

import org.junit.Test;

public class Solution {

    @Test
    public void test() {
        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1, 0, nums2, 1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // from tail to head, merge two arrays
        // two pointers from nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0)
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        // add missing elements from nums2
        // 处理num1中无元素的情况
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
