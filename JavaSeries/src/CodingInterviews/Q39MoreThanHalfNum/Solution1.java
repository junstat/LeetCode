package CodingInterviews.Q39MoreThanHalfNum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    解法二: 根据数组特点找出时间复杂度为O(n)的算法
        数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现次数的和还要多。因此，我们可以考虑在遍历数组的时候保存
    两个值：一个是数组中的遍历数字；另一个是次数。当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加1；如果下一个数字和
    我们之前保存的数字不同，则次数减1。如果次数为零，那么我们需要保存下一个数字，并把次数设为1。由于我们要找的数字出现的次数比其他所有的数字出现的
    次数之和还要多，那么要找的数字肯定是最后一次把次数设为1时对应的数字。
 */
public class Solution1 {

    @Test
    public void test1() {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        assertEquals(moreThanHalfNum(arr), 2);
    }

    public int moreThanHalfNum(int[] array) {
        if (array == null || array.length == 0) return 0;

        int result = 0, times = 0;
        for (int num : array) {
            if (times == 0) {
                result = num;
                times = 1;
            } else if (num == result) times++;
            else times--;
        }
        times = 0;
        for (int num : array) if (num == result) times++;
        return times > array.length >> 1 ? result : 0;
    }
}
