package CodingInterviews.Q62LastRemaining;

import java.util.LinkedList;

/*
    面试题62: 圆圈中最后剩下的数字
        0, 1, ..., n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 */
public class Solution {
    /*
       经典的解法
           既然题目中有一个数字圆圈，很自然的想法就是用一个数据结构来模拟这个圆圈。在常用的数据机构中，很容易想到环形链表。可以创建一个共有n个节点的环形链表，然后每次在这个链表中删除第m个节点。
     */
    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) return -1;

        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < n; i++)
            numbers.add(i);

        int current = 0;
        while (numbers.size() > 1) {
            current = (current + m - 1) % numbers.size();
            numbers.remove(current);
        }
        return numbers.getFirst();
    }
}
