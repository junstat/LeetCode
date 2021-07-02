package CodingInterviews.Q06PringListFromTailToHead;

import DataStructure.ListNode;

import java.util.ArrayList;

public class Solution1 {
    public ArrayList<Integer> printListFromTailToHead(ListNode head) {
        ArrayList<Integer> result = new ArrayList<>();
        if (head == null) return result;
        addList(head, result);
        return result;
    }

    private void addList(ListNode head, ArrayList<Integer> result) {
        if (head != null) {
            addList(head.next, result);
            result.add(head.val);
        }
    }
}
