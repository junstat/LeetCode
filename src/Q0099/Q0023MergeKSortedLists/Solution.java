package Q0099.Q0023MergeKSortedLists;

import DataStructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

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
       方法一: 利用Q21合并两个List,顺序合并
       时间复杂度: O(k^2n) k = lists.size()
       空间复杂读: O(1)
      */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode list : lists) {
            ans = mergeTwoLists(ans, list);
        }
        return ans;
    }
}
