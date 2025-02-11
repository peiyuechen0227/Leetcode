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
    // Track the previous node
    TreeNode pre;
    // Initialize the result with maximum integer
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        // Edge case: If tree is empty
        if (root == null) {
            return 0;
        }
        traversal(root);
        return result;
    }
    void traversal(TreeNode root) {
        // Base case: return if root is null
        if (root == null) {
            return;
        }
        // In-order traversal
        traversal(root.left);
        // Compute the absolute difference between current node and previous node
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        // Update the previous node
        pre = root;
        traversal(root.right);
    }
}
