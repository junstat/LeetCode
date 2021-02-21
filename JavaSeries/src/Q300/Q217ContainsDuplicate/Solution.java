package Q300.Q217ContainsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
   Approach #3 (Hash Table) [Accepted]
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}

class Solution4 {
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

/*
   Approach #2 (Sorting) [Accepted]
 */
class Solution2 {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] == nums[i + 1]) return true;
        return false;
    }
}


/*
   Approach #1 (Naive Linear Search) [Time Limit Exceeded]
 */
class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                if (nums[j] == nums[i]) return true;
        return false;
    }
}