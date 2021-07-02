package Q0199.Q0144BinaryTreePreorderTraversal;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
   先序遍历: 根左右
   method 1: 递归做法
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(result, root);
        return result;
    }

    private void helper(List<Integer> result, TreeNode root) {
        if (root != null) {
            result.add(root.val);
            helper(result, root.left);
            helper(result, root.right);
        }
    }
}
