package Q0199.Q0106ConstructBinaryTreefromInorderandPostorderTraversal;

import DataStructure.TreeNode;

public class Solution {
    private int in = 0;  // index of inorder array
    private int post = 0;  // index of postorder array

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in = inorder.length - 1;
        post = postorder.length - 1;
        return build(postorder, inorder, null);
    }

    private TreeNode build(int[] postorder, int[] inorder, TreeNode end) {
        if (post < 0) return null;

        // create root node
        TreeNode root = new TreeNode(postorder[post--]);

        // if right node exist, create right subtree
        if (inorder[in] != root.val)
            root.right = build(postorder, inorder, root);

        in--;

        // if left node exist, create left subtree
        if ((end == null) || (inorder[in] != end.val))
            root.left = build(postorder, inorder, end);

        return root;
    }
}


