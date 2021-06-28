package Q0099.Q0004MedianofTwoSortedArrays;

public class Solution1 {
    /**
     * find median in two sorted array
     *
     * @param arr1 int整型一维数组 the array1
     * @param arr2 int整型一维数组 the array2
     * @return int整型
     */
    public int findMedianInTwoSortedArray(int[] arr1, int[] arr2) {
        // write code here
        if (null == arr1 || null == arr2 || arr1.length != arr2.length)
            throw new RuntimeException("Invalid input array!");

        int start1 = 0;
        int end1 = arr1.length - 1;
        int start2 = 0;
        int end2 = arr2.length - 1;
        int mid1 = 0;
        int mid2 = 0;
        int offset = 0;
        while (start1 < end1) {
            mid1 = (start1 + end1) / 2;
            mid2 = (start2 + end2) / 2;

            // 数组长度为奇数时，offset=0；数组长度为偶数时，offset=1
            offset = ((end1 - start1 + 1) & 1) ^ 1; // 数组长度在不断缩减
            if (arr1[mid1] > arr2[mid2]) {
                end1 = mid1;
                start2 = mid2 + offset;
            } else if (arr1[mid1] < arr2[mid2]) {
                start1 = mid1 + offset;
                end2 = mid2;
            } else {
                return arr1[mid1];
            }
        }

        return Math.min(arr1[start1], arr2[start2]);  // 数组长度为1时，直接返回组合数组的最小元素
    }
}
