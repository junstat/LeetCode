package CodingInterviews.Q40GetLeastNumbers;


/*
   面试题40: 最小的k个数
      输入n个整数，找出其中最小的k个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */

import CodingInterviews.util.IntegerArrayUtil;
import org.junit.Test;

import java.util.ArrayList;


public class Solution {
    @Test
    public void test1() throws Exception {
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(getLeastNumbers(nums, 4));
    }

    public ArrayList<Integer> getLeastNumbers(int[] input, int k) throws Exception {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length) return result;
        int start = 0, end = input.length - 1;
        int index = IntegerArrayUtil.partition(input, start, end);
        while (index != k - 1) {
            if (index > k - 1) end = index - 1;
            else start = index + 1;
            index = IntegerArrayUtil.partition(input, start, end);
        }
        for (int i = 0; i < k; i++) result.add(input[i]);
        return result;
    }


}
