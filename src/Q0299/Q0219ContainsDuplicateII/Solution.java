package Q0299.Q0219ContainsDuplicateII;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/*

 */
public class Solution {

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    @Test
    public void test2() {
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}
