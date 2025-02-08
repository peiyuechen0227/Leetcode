/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        return getDepth(root);
    }


    int getDepth(TreeNode root) {
        // Base case: if the node is null, the depth is 0
        if (root == null) {
            return 0;
        }

        // Case 1: if the node only has left child, recursive its left child
        if (root.left != null && root.right == null) {
            return 1 + getDepth(root.left);
        }
        // Case 2: if the node only has right child, recursive its right child
        if (root.right != null && root.left == null) {
            return 1 + getDepth(root.right);
        }
        return 1 + Math.min(getDepth(root.left), getDepth(root.right));
    }
}
