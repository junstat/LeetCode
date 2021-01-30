package Q200.Q109ConvertSortedListtoBinarySearchTree;

import DataStructure.ListNode;
import DataStructure.TreeNode;

import java.util.ArrayList;

public class Solution {
    /*
       方法一: 遍历链表将val保存到 array，套用Q 108
      */
    public TreeNode helper(ArrayList<Integer> nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) / 2;

        TreeNode root = new TreeNode(nums.get(mid));
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ArrayList<Integer> array = new ArrayList<>();
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }
        return helper(array, 0, array.size() - 1);
    }

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
