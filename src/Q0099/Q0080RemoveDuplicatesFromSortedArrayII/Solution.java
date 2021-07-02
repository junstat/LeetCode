package Q0099.Q0080RemoveDuplicatesFromSortedArrayII;

public class Solution {
    /*
       Q026 的续集
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) nums[i++] = n;
        }
        return i;
    }
}
