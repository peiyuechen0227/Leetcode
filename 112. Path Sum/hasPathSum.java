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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // Subtract the current node value from the target sum
        targetSum -= root.val;

        // If it's a leaf node, check is the remaining sum is 0
        if (root.left == null && root.right == null) {
            if (targetSum == 0) return true;
            else return false;
        }

        // Recursively check the left and right subtrees
        if (root.left != null) {
            if (hasPathSum(root.left, targetSum)) return true;
        }
        if (root.right != null) {
            if (hasPathSum(root.right, targetSum)) return true;
        }
        return false;
    }
}