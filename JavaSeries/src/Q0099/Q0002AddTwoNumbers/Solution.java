package Q0099.Q0002AddTwoNumbers;

import DataStructure.ListNode;

/*
    分析:
        1. 整体的思想是模拟手算加法： p1.val(获取操作数1) + p2.val2(操作数2) = sum;
            则，保存当前位结果值为sum的个位(sum % 10)，并将sum的十位作为进位传递给下一位进行计算。
        2. 注意点1: 进入循环的条件是: p1 != null || p2 != null ,即 l1,l2只要有一个不为空就可以计算，
            避免l1, l2长度不一致，在循环外做额外的处理。
        3. 注意点2: 循环结束后，检查进位是否为0，不然需要把进位的值保存下来；
        4. 注意点3: 创建虚拟头节点dummy，是因为，每一位保存值的方式都是将值保存到的cur.next.val，而给头节点赋值则是cur.val;
            为了后续操作一致，浪费掉头节点。
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);  // 挂头结点
        int sum = 0;
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null) {
            int n1 = p1 != null ? p1.val : 0;
            int n2 = p2 != null ? p2.val : 0;
            sum = n1 + n2 + sum;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum /= 10;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        } // end of while loop
        if (sum != 0) cur.next = new ListNode(sum);
        return dummy.next;
    }
}
