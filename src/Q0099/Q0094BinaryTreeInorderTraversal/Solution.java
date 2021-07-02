package Q0099.Q0094BinaryTreeInorderTraversal;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
       方法一: 递归
     */
    public void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }
}
