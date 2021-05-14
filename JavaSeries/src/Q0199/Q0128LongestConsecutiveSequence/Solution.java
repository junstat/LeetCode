package Q0199.Q0128LongestConsecutiveSequence;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/*
   We will use HashMap. The key thing is to keep track of the sequence length and store that in the boundary points of the sequence. For example, as a result, for sequence {1, 2, 3, 4, 5}, map.get(1) and map.get(5) should both return 5.

    Whenever a new element n is inserted into the map, do two things:

    1) See if n - 1 and n + 1 exist in the map, and if so, it means there is an existing sequence next to n. Variables left and right will be the length of those two sequences, while 0 means there is no sequence and n will be the boundary point later. Store (left + right + 1) as the associated value to key n into the map.
    2) Use left and right to locate the other end of the sequences to the left and right of n respectively, and replace the value with the new length.
Everything inside the for loop is O(1) so the total time is O(n).
 */
public class Solution {

    @Test
    public void test1() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        assertEquals(longestConsecutive(nums), 4);
    }

    @Test
    public void test2() {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        assertEquals(longestConsecutive(nums), 9);
    }

    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> ranges = new HashMap<>();
        for (int n : nums) {
            if (ranges.containsKey(n)) continue;
            // 1. Find left and right num
            int left = ranges.getOrDefault(n - 1, 0);
            int right = ranges.getOrDefault(n + 1, 0);
            int sum = left + right + 1;
            res = Math.max(res, sum);

            // 2. Union by only updating boundary
            // Leave middle k-v dirty to avoid cascading update
            if (left > 0) ranges.put(n - left, sum);
            if (right > 0) ranges.put(n + right, sum);
            ranges.put(n, sum);  // Keep each number in Map to de-duplicate
        }
        return res;
    }
}
