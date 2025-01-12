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
    public int maxDepth(TreeNode root) {
        // Calculate the maximum depth of the Binary tree
        int maxDepth = findDepth(root);
        return maxDepth;
    }

    public int findDepth(TreeNode node) {
        // Base case: if node is null, it represents an empty tree, return 0
        if (node == null) {
            return 0;
        }
        // Recursively find the depth of the left and right subtree
        int leftDepth = findDepth(node.left);
        int rightDepth = findDepth(node.right);
        // return the greater depth between the left and right subtree, add 1 for the current node
        return 1 + Math.max(leftDepth, rightDepth);
    }
}