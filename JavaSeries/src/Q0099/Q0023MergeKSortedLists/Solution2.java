package Q0099.Q0023MergeKSortedLists;

import DataStructure.ListNode;

public class Solution2 {
    // 来自Q21
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 != null ? l1 : l2;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /*
   方法二: 分治合并
   1、将lists 分为 [lists.size() / 2] + 1 组
   2、组内合并
   重复以上操作，直至合并为1个链表
   时间复杂度: O(kn x logk)
   空间复杂度: O(logk)
 */
    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if (l > r) return null;
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

}
