package Q0199.Q0102BinaryTreeLevelOrderTraversal;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) return result;

        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            List<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < cnt; i++) {
                TreeNode curNode = queue.poll();
                assert curNode != null;
                curLevel.add(curNode.val);
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }
            result.add(curLevel);
        }
        return result;
    }
}
