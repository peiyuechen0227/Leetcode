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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // Edge case: return new root if root is null
        if (root == null) {
            return new TreeNode(val);
        }

        // Track the current and previous nodes through iteration
        TreeNode cur = root;
        TreeNode pre = root;

        // Iterate the tree to find the insert position
        while (cur != null) {
            pre = cur;
            // Move to the left subtree if the value to insert is smaller
            if (cur.val > val) {
                cur = cur.left;
            } else if (cur.val < val) { // Move to the right subtree if the value to insert is larger
                cur = cur.right;
            }
        }

        // Insert the new value at the appropriate position.
        if (val < pre.val) {
            TreeNode node = new TreeNode(val);
            pre.left = node;
        }
        if (val > pre.val) {
            TreeNode node = new TreeNode(val);
            pre.right = node;
        }
        return root;
    }
}