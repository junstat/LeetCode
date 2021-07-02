package CodingInterviews.Q06PringListFromTailToHead;

import DataStructure.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/*
   方法一:  用栈
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode head) {
        ArrayList<Integer> result = new ArrayList<>();
        if (head == null) return result;

        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            stack.addFirst(head.val);
            head = head.next;
        }

        while(!stack.isEmpty())
            result.add(stack.pop());

        return result;
    }
}
