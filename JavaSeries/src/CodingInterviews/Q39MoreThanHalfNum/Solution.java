package CodingInterviews.Q39MoreThanHalfNum;

/*
   面试题39: 数组中出现次数超过一半的数字
      数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如，输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2
   在数组中出现了5次，超过数组长度的一半，因此输出2。
 */

import CodingInterviews.util.IntegerArrayUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
   解法一: 基于Partition函数的时间复杂度为O(n)的算法
      这种算法受快速排序算法的启发。在随机快速排序算法中，我们先在数组中随机选择一个数字，然后调整数组中数字的顺序，使得比选中的数字小的数字都
   排在它的左边，比选中的数字大的数字都排在它的右边。如果这个选中的数字的下标刚好是n/2，那么这个数字就是数组的中位数；如果它的下标大于n/2，那
   么中位数应该位于它的左边，我们可以接着在它的左边部分的数组中查找；如果它的下标小于n/2，那么中位数应该位于它的右边，我们可以接着在它的右边部
   分的数组中查找。

   时间复杂度: O(n)
   空间复杂度: O(1)
 */
public class Solution {

    @Test
    public void test1() throws Exception {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        assertEquals(moreThanHalfNum(arr), 2);
    }

    public int moreThanHalfNum(int[] array) throws Exception {
        if (array == null || array.length == 0) return 0;
        int middle = array.length >> 1, start = 0, end = array.length - 1;
        int index = IntegerArrayUtil.partition(array, start, end);

        while (index != middle) {
            if (index > middle) end = index - 1;
            else start = index + 1;
            index = IntegerArrayUtil.partition(array, start, end);
        }

        int result = array[middle], times = 0;
        for (int num : array) if (num == result) times++;
        return times > array.length >> 1 ? result : 0;
    }
}
