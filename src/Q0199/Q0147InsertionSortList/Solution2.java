package Q0199.Q0147InsertionSortList;

import DataStructure.ListNode;

/*
   100%
 */
public class Solution2 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode rightHead = mid.next, ans1, ans2;
        mid.next = null;
        ans1 = insertionSortList(head);
        ans2 = insertionSortList(rightHead);
        return merge(ans1, ans2);
    }

    public ListNode merge(ListNode head, ListNode rightHead) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (head != null && rightHead != null) {
            if (head.val <= rightHead.val) {
                temp.next = head;
                head = head.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
            }
            temp = temp.next;
        }
        if (head != null) {
            temp.next = head;
        }
        if (rightHead != null) {
            temp.next = rightHead;
        }
        return dummy.next;
    }

    public ListNode getMid(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
