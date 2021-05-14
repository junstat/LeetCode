package Q0099.Q0004MedianofTwoSortedArrays;/*
    分析：
      <1.> 只考虑一个有序数组的时候，找中位数，我们做了什么？
           中位数定义: 中位数（又称中值，英语：Median），统计学中的专业名词，代表一个样本、种群或概率分布中的一个数值，
           其可将数值集合划分为数量相等的上下两部分。对于有限的数集，可以通过把所有观察值高低排序后找出正中间的一个作为中位数。
           如果观察值有偶数个，则中位数不唯一，通常取最中间的两个数值的平均数作为中位数。
           来自wikipedia: https://zh.wikipedia.org/wiki/%E4%B8%AD%E4%BD%8D%E6%95%B8
           所以：只需要找到一个位置，把序列划分为size相同的两part即可，当然，序列length为奇数即为中间数值，不然要求和取平均。
           如: nums给定为如下序列:
           1 2 3 5 7 8 9 10 11 12
           则，len(nums) = 10, 很快可以定位，中间位置在7和8之间，序列被分为size为5的两part, 求和取平均即得中位数(7+8)*0.5 = 7.5。
      <2.> 如果是两个有序序列的时候呢？
           以下给定nums1, nums2
           nums1:      3  5     8  9
           nums2: 1  2       7       10 11 12
           可以发现: nums1并nums2即为<1.>中的nums，由<1.> 可知中间位置定在7, 8之间
           于是，在num1,num2中7，8附近插入隔断:
           nums1:      3  5    | 8  9
           nums2: 1  2       7 |      10 11 12
           观察发现:
           a. 在隔断左侧有: 1 2 3 5 7 共5个数，右侧有: 8 9 10 11 12 共5个数 => 隔断把序列分为size为5的两part。
           b. nums1的隔断cut1两边的值为，左l1 = 5, r1=8; nums2的隔断 cur2两边l2=7, r2=10。=> l1 <= r2 && l2 <= r1
           c. 因为len(nums1) + len(nums2) = 10为偶数 => 中位数为(7+8)*0.5 = 7.5
           于是，问题变为求解满足上述a. b. c. 的cur1,cu2的位置。进一步地，使用二分查找加快查找速度。
 */

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int len = nums1.length + nums2.length;
        // 在nums1上执行二分查找
        int start = 0, end = nums1.length;
        while (start <= end) {
            int cut1 = start + (end - start) / 2;
            int cut2 = len / 2 - cut1; // 根据 a. 及 cut1 => cut2
            double l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double r1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            double r2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            if (l1 > r2) end = cut1 - 1;
            else if (l2 > r1) start = cut1 + 1;
            else {
                if (len % 2 == 0) {
                    l1 = Math.max(l1, l2);
                    r1 = Math.min(r1, r2);
                    return (l1 + r1) / 2;
                } else {
                    return Math.min(r1, r2);
                }
            }
        }
        return -1;
    }
}
