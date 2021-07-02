package Q0099.Q0055JumpGame;
/*
   执行用时：1 ms, 在所有 Java 提交中击败了99.98%的用户
   内存消耗：40.2 MB, 在所有 Java 提交中击败了82.21%的用户
 */
public class Solution2 {
    // 从后往前推
    public boolean canJump(int[] nums) {
        int n = nums.length, last = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }
        return last == 0;
    }
}

