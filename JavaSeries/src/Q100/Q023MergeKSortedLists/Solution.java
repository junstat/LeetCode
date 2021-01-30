package Q100.Q023MergeKSortedLists;

import DataStructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    // 来自Q21
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 != null ? l1 : l2;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    /*
       方法一: 利用Q21合并两个List,顺序合并
       时间复杂度: O(k^2n) k = lists.size()
       空间复杂读: O(1)
      */
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode list : lists) {
            ans = mergeTwoLists1(ans, list);
        }
        return ans;
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
        return mergeTwoLists1(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    /*
       方法三: 优先队列
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        Comparator<ListNode> cmp = Comparator.comparingInt(a -> a.val);
        PriorityQueue<ListNode> q = new PriorityQueue<>(cmp);
        for (ListNode list : lists) if (list != null) q.add(list);
        while (!q.isEmpty()) {
            cur.next = q.poll();
            cur = cur.next;
            if (cur.next != null) q.add(cur.next);
        }
        return dummy.next;
    }
}
