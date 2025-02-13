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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // Base case: return null if root is null
        if (root == null) {
            return null;
        }

        // If root.val is smaller than low, replace it with its right children
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        // If root.val is larger than low, replace it with its left children
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // If root.val lies in [low, high], recursively check its children
        if (root.val >= low && root.val <= high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
}