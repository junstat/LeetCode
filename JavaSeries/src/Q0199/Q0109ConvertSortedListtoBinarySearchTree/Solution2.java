package Q0199.Q0109ConvertSortedListtoBinarySearchTree;

import DataStructure.ListNode;
import DataStructure.TreeNode;

public class Solution2 {
    /*
   方法二: 链表找中点
  */
    public ListNode findMid(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public TreeNode builder(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode midNode = findMid(head, tail);
        TreeNode root = new TreeNode(midNode.val);
        root.left = builder(head, midNode);
        root.right = builder(midNode.next, tail);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return builder(head, null);
    }
}
