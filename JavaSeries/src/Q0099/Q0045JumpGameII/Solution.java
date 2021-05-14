package Q0099.Q0045JumpGameII;

public class Solution {
    /*
      Explanation

       The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], curFarthest is
    the farthest point that all points in [curBegin, curEnd] can reach. Once the current point reaches curEnd, then
    trigger another jump, and set the new curEnd with curFarthest, then keep the above steps, as the following:
     */
    public int jump(int[] nums) {
        int curEnd = 0, curFarthest = 0, steps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, nums[i] + i);
            if (i == curEnd) {
                steps++;
                curEnd = curFarthest;
            }
            if (curEnd >= nums.length - 1) break;
        }
        return steps;
    }
}
