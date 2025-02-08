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
    public boolean isBalanced(TreeNode root) {
        if (getDepth(root) == -1) {
            return false;
        }
        return true;
    }

    int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // the depth of the left subtree and the right subtree
        int leftDepth = getDepth(node.left);
        // If the left subtree is not balanced
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getDepth(node.right);
        // If the right subtree is not balanced
        if (rightDepth == -1) {
            return -1;
        }

        int result = 0;
        // If the depth of two subtrees differs by more than one, return -1
        if (Math.abs(leftDepth - rightDepth) > 1) {
            result = -1;
        }

        else result = 1 + Math.max(leftDepth, rightDepth);
        return result;
    }
}
