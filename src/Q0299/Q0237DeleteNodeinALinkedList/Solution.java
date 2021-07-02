package Q0299.Q0237DeleteNodeinALinkedList;

import DataStructure.ListNode;

public class Solution {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}