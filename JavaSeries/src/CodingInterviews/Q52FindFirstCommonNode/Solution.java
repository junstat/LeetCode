package CodingInterviews.Q52FindFirstCommonNode;

import DataStructure.ListNode;

public class Solution {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int nLength1 = getListLength(pHead1);
        int nLength2 = getListLength(pHead2);
        int nLengthDif = nLength1 - nLength2;

        ListNode pListHeadLong = pHead1;
        ListNode pListHeadShort = pHead2;

        if (nLength2 > nLength1) {
            pListHeadLong = pHead2;
            pListHeadShort = pHead1;
            nLengthDif = nLength2 - nLength1;
        }

        // 先在长链表上走几步，再同时在两个链表上遍历
        for (int i = 0; i < nLengthDif; ++i)
            pListHeadLong = pListHeadLong.next;

        while ((pListHeadLong != null) &&
                (pListHeadShort != null) &&
                (pListHeadLong != pListHeadShort)
        ) {
            pListHeadLong = pListHeadLong.next;
            pListHeadShort = pListHeadShort.next;
        }

        // 得到第一个公共节点
        ListNode pFirstCommonNode = pListHeadLong;
        return pFirstCommonNode;
    }

    private int getListLength(ListNode pHead) {
        int len = 0;
        ListNode pNode = pHead;
        while (pNode != null) {
            ++len;
            pNode = pNode.next;
        }
        return len;
    }
}
