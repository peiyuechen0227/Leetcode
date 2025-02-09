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
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = getLeftLeaves(root);
        return sum;
    }

    int getLeftLeaves(TreeNode root) {
        // If root is null, return 0
        if (root == null) {
            return 0;
        }

        // If root is leaf node, return 0;
        if (root.left == null && root.right == null) {
            return 0;
        }

        // Recursively calculate the sum from the left and right subtrees
        int leftSum = getLeftLeaves(root.left);
        int rightSum = getLeftLeaves(root.right);

        // If root.left is a left leaf, add its value to leftSum
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftSum = root.left.val;
        }

        // Return total sum of left leaves in both subtrees
        return leftSum + rightSum;
    }
}
