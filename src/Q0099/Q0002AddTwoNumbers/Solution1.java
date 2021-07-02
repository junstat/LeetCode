package Q0099.Q0002AddTwoNumbers;

import DataStructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
   NC40 两个链表生成相加链表
    描述
    假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
    给定两个这种链表，请生成代表两个整数相加值的结果链表。
    例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
    937 + 63 = 1000

    思路:
    1、因为求和的时候是链表遍历的逆序，所以遍历链表，把值存到栈中。
    2、结果也是逆序，也存到栈中
    3、注意进位
 */
public class Solution1 {
    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode l1, ListNode l2) {
        Deque<Integer> l1Values = new ArrayDeque<>();
        Deque<Integer> l2Values = new ArrayDeque<>();
        Deque<Integer> result = new ArrayDeque<>();
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        int sum = 0;

        while (p1 != null) {
            l1Values.push(p1.val);
            p1 = p1.next;
        }

        while (p2 != null) {
            l2Values.push(p2.val);
            p2 = p2.next;
        }

        while (!l1Values.isEmpty() || !l2Values.isEmpty()) {
            int n1 = !l1Values.isEmpty() ? l1Values.pop() : 0;
            int n2 = !l2Values.isEmpty() ? l2Values.pop() : 0;
            sum = n1 + n2 + sum;
            result.push(sum % 10);
            sum /= 10;
        }

        if (sum != 0) result.push(sum);

        while (!result.isEmpty()) {
            cur.next = new ListNode(result.pop());
            cur = cur.next;
        }

        return dummy.next;
    }
}
