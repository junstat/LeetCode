package Q0199.Q0148SortList;

import DataStructure.ListNode;

import java.util.Arrays;
/*
   99.86%
 */
public class Solution2 {

    public ListNode sortList(ListNode head) {
        if (null == head) {
            return null;
        }
        int size = 1;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
            ++size;
        }
        int[] nodes = new int[size];
        last = head;
        int i = 0;
        while (i < size) {
            nodes[i] = last.val;
            last = last.next;
            ++i;
        }
        Arrays.sort(nodes);
        ListNode first = head;
        for (i = 0; i < size; ++i) {
            first.val = nodes[i];
            first = first.next;
        }

        return head;
    }

}
