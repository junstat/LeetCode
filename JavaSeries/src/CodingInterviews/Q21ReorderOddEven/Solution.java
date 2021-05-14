package CodingInterviews.Q21ReorderOddEven;

import org.junit.Test;

import java.util.Arrays;

import static CodingInterviews.util.IntegerArrayUtil.exchange;

/*
   方法一: 只完成基本功能的解法，仅适用于初级程序员
   维护两个指针: 第一个指针初始化时指向数组的第一个数字，它只向后移动；第二个指针初始化时指向数组的最后一个数字，它只向前移动。在两个指针相遇
   之前，第一个指针总是位于第二个指针的前面。如果第一个指针指向的数字是偶数，并且第二个指针指向的数字是奇数，则交换这两个数字。
 */
public class Solution {

    @Test
    public void test1() {
        int[] arr = {1, 2, 3, 4};
        reorderOddEven(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void reorderOddEven(int[] array) {
        if (array == null || array.length == 0) return;

        int begin = 0, end = array.length - 1;
        while (begin < end) {
            // 向后移动begin，直到它指向偶数
            while (begin < end && (array[begin] & 1) > 0) begin++;

            // 向前移动end, 直到它指向奇数
            while (begin < end && (array[end] & 1) == 0) end--;

            if (begin < end) exchange(array, begin, end);
        }
    }
}
