package Q0099.Q0015ThreeSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        //先排序
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1, high = nums.length - 1, sum = -nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        if (nums[low] == nums[high])
                            break;
                        //避免出现重复三元组，将双指针都向中间靠拢跳过中间重复的
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        //匹配成功后两个指针再靠拢一格
                        low++;
                        high--;
                    } else if (nums[low] == nums[high]) {
                        break;
                    } else if (nums[low] + nums[high] < sum) {
                        // while(low<high&&nums[low]==nums[low+1])low++;
                        low++;
                    } else {
                        // while(low<high&&nums[high]==nums[high-1])high--;
                        high--;
                    }
                }
            }
        }
        return list;
    }
}
