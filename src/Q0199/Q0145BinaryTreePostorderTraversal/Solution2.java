package Q0199.Q0145BinaryTreePostorderTraversal;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    /*
       迭代
       时间复杂度: O(n)，其中n是二叉树的结点数。
       空间复杂度: O(n)，为迭代过程中显式栈的开销，平均情况下为O(log n)，最坏情况下树呈现链状为O(n).
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}