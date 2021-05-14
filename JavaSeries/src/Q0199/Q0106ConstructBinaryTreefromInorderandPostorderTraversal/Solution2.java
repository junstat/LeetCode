package Q0199.Q0106ConstructBinaryTreefromInorderandPostorderTraversal;

import DataStructure.TreeNode;

public class Solution2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }

        return buildTree(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder, int start, int end, int rootIndex) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[rootIndex]);
        int i = 0;
        while (postorder[rootIndex] != inorder[end - i]) {
            i++;
        }

        root.left = buildTree(inorder, postorder, start, end - i - 1, rootIndex - i - 1);
        root.right = buildTree(inorder, postorder, end - i + 1, end, rootIndex - 1);

        return root;
    }
}
