package Q0199.Q0105ConstructBinaryTreefromPreorderandInorderTraversal;

import DataStructure.TreeNode;

public class Solution {
    /*
       The basic idea is here:
        Say we have 2 arrays, PRE and IN.
        Preorder traversing implies that PRE[0] is the root node.
        Then we can find this PRE[0] in IN, say it's IN[5].
        Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
        Recursively doing this on subarrays, we can build a tree out of it :)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        // preStart 即为 root
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;  // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        // 左子树: root为 PRE[preStat+1], range: [inStart, inIndex - 1] =>
        // 左子树元素个数 inIndex - 1 - inStart + 1 = inIndex - inStart
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        // 右子树: root为 preStart + inIndex - inStart + 1(先序遍历中，越过 root, 越过 左子树范围 的下一个节点)
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}

