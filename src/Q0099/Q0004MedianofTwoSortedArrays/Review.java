package Q0099.Q0004MedianofTwoSortedArrays;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
   [Hard]
   Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
    Example 1:
        Input: nums1 = [1,3], nums2 = [2]
        Output: 2.00000
        Explanation: merged array = [1,2,3] and median is 2.
    Example 2:
        Input: nums1 = [1,2], nums2 = [3,4]
        Output: 2.50000
        Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
    Example 3:
        Input: nums1 = [0,0], nums2 = [0,0]
        Output: 0.00000
    Example 4:
        Input: nums1 = [], nums2 = [1]
        Output: 1.00000
    Example 5:
        Input: nums1 = [2], nums2 = []
        Output: 2.00000

    Constraints:
        nums1.length == m
        nums2.length == n
        0 <= m <= 1000
        0 <= n <= 1000
        1 <= m + n <= 2000
        -10^6 <= nums1[i], nums2[i] <= 10^6

    Follow up: The overall run time complexity should be O(log (m+n)).
 */
public class Review {

    @Test
    public void test() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        assertEquals(findMedianSortedArrays(nums1, nums2), 2.5D);
    }


    @Test
    public void test2() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        assertEquals(findMedianSortedArrays(nums1, nums2), 2.0D);
    }

    /*
          a. 在隔断左侧有: 1 2 3 5 7 共5个数，右侧有: 8 9 10 11 12 共5个数 => 隔断把序列分为size为5的两part。
          b. nums1的隔断cut1两边的值为，左l1 = 5, r1=8; nums2的隔断 cur2两边l2=7, r2=10。=> l1 <= r2 && l2 <= r1
          c. 因为len(nums1) + len(nums2) = 10为偶数 => 中位数为(7+8)*0.5 = 7.5
           于是，问题变为求解满足上述a. b. c. 的cur1,cu2的位置。进一步地，使用二分查找加快查找速度。
     */
    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return -1;
    }
}
