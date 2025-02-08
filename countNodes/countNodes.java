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
    public int countNodes(TreeNode root) {
        return getNodesSum(root);
    }

    int getNodesSum(TreeNode node) {
        // Base case: if the node is null, return 0
        if (node == null) {
            return 0;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;

        // depth of the left and right tree
        int leftDepth = 0;
        int rightDepth = 0;

        // Find the depth of the left child
        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        // Find the depth of the right child
        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        // If leftDepth = rightDepth, Full Binary Tree
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;
        }

        int leftSum = getNodesSum(node.left);
        int rightSum = getNodesSum(node.right);

        return 1 + leftSum + rightSum;
    }
}
