package Q0099.Q0041FirstMissingPositive;

/*
   执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
   内存消耗：84.2 MB, 在所有 Java 提交中击败了6.21%的用户
 */
public class Solution2 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if (n >= 500000) {
            return 500001;
        }
        int[] arr = new int[301];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] < 301) {
                arr[nums[i]] = 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] != 1) {
                return i;
            }
        }
        return n + 1;
    }
}
