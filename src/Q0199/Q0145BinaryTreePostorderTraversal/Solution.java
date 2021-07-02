package Q0199.Q0145BinaryTreePostorderTraversal;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(result, root);
        return result;
    }

    private void helper(List<Integer> result, TreeNode root) {
        if (root != null) {
            helper(result, root.left);
            helper(result, root.right);
            result.add(root.val);
        }
    }
}
