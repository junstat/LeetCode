package Q0299.Q0217ContainsDuplicate;

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
