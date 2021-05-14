package Q0199.Q0109ConvertSortedListtoBinarySearchTree;

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

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ArrayList<Integer> array = new ArrayList<>();
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }
        return helper(array, 0, array.size() - 1);
    }
}
