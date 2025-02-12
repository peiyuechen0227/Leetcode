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
    public TreeNode deleteNode(TreeNode root, int key) {
        // Edge case: if root is null, return null
        if (root == null) {
            return root;
        }

        // root.val == key, found the node to delete
        if (root.val == key) {
            // Case 1: The node has no left child, return to right child to replace it
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) { // Case 2: The node has no right child, return to left child to replace it
                return root.left;
            } else {
                // Case 3: The node has both left and right children
                // Find the rightmost node in the left subtree
                TreeNode cur = root.left;
                while (cur.right != null) {
                    cur = cur.right;
                }
                // Attach the right subtree of the deleted node
                cur.right = root.right;
                // Replace the deleted node with its left subtree
                root = root.left;
                return root;
            }
        }
        // Search for the node to delete
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
