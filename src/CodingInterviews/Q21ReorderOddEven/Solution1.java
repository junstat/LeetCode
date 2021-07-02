package CodingInterviews.Q21ReorderOddEven;

import static CodingInterviews.util.IntegerArrayUtil.exchange;

/*
   方法二: 考虑可扩展的解法，能秒杀Offer
        把逻辑框架抽象出来。
 */
public class Solution1 {
    public void reorderOddEven(int[] array) {
        if (array == null || array.length == 0) return;

        int begin = 0, end = array.length - 1;

        while (begin < end) {
            while (begin < end && !isEven(array[begin])) begin++;
            while (begin < end && isEven(array[end])) end--;

            if (begin < end) exchange(array, begin, end);
        }
    }

    private boolean isEven(int n) {
        return (n & 1) == 0;
    }
}
