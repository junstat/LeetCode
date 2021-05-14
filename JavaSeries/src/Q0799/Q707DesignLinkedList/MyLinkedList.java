package Q0799.Q707DesignLinkedList;

import DataStructure.ListNode;

public class MyLinkedList {
    private final ListNode dummy;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        dummy = new ListNode();
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        ListNode cur = dummy.next;
        while (index > 0 && cur != null) {
            --index;
            cur = cur.next;
        }
        if (index > 0 || cur == null) return -1;
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode p = dummy.next;
        dummy.next = new ListNode(val);
        dummy.next.next = p;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode pre = dummy;
        while (pre.next != null) pre = pre.next;
        pre.next = new ListNode(val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
            return;
        }
        ListNode pre = dummy;
        while (index > 0 && pre != null) {
            --index;
            pre = pre.next;
        }
        if (pre == null) return;
        ListNode p = pre.next;
        pre.next = new ListNode(val);
        pre.next.next = p;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0) return;
        ListNode pre = dummy;
        while (index > 0 && pre != null) {
            --index;
            pre = pre.next;
        }
        if (pre == null || pre.next == null) return;
        pre.next = pre.next.next;
    }

}
