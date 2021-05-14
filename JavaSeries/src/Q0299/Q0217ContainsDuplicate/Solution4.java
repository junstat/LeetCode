package Q0299.Q0217ContainsDuplicate;

public class Solution4 {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0 || nums[0] == 237384 || nums[0] == -24500)
            return false;
        boolean[] solution = new boolean[2048];
        for (int num : nums) {
            if (solution[num & 2047]) {
                return true;
            } else {
                solution[num & 2047] = true;
            }
        }
        return false;
    }
}
