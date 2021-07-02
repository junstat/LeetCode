package Q0099.Q0090SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
       method 1: 非递归
       To solve this problem, it is helpful to first think how many subsets are there. If there is no duplicate element, the answer is simply 2^n, where n is the number of elements. This is because you have two choices for each element, either putting it into the subset or not. So all subsets for this no-duplicate set can be easily constructed:
        num of subset

        (1 to 2^0) empty set is the first subset
        (2^0+1 to 2^1) add the first element into subset from (1)
        (2^1+1 to 2^2) add the second element into subset (1 to 2^1)
        (2^2+1 to 2^3) add the third element into subset (1 to 2^2)
        ....
        (2^(n-1)+1 to 2^n) add the nth element into subset(1 to 2^(n-1))
        Then how many subsets are there if there are duplicate elements? We can treat duplicate element as a spacial element. For example, if we have duplicate elements (5, 5), instead of treating them as two elements that are duplicate, we can treat it as one special element 5, but this element has more than two choices: you can either NOT put it into the subset, or put ONE 5 into the subset, or put TWO 5s into the subset. Therefore, we are given an array (a1, a2, a3, ..., an) with each of them appearing (k1, k2, k3, ..., kn) times, the number of subset is (k1+1)(k2+1)...(kn+1). We can easily see how to write down all the subsets similar to the approach above.
     */
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        result.add(empty);
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int dupCount = 0;
            while (((i + 1) < nums.length) && nums[i + 1] == nums[i]) {
                dupCount++;
                i++;
            }
            int prevNum = result.size();
            for (int j = 0; j < prevNum; j++) {
                List<Integer> element = new ArrayList<>(result.get(j));
                for (int t = 0; t <= dupCount; t++) {
                    element.add(nums[i]);
                    result.add(new ArrayList<>(element));
                }
            }
        }
        return result;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;  // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


}
