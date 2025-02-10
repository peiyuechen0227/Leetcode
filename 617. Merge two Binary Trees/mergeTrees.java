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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // Base case: if root1 and root2 both are null, return null
        if (root1 == null && root2 == null) {
            return null;
        }
        // If one of them is null, return the other one
        if (root1 != null && root2 == null) {
            return root1;
        }
        if (root1 == null && root2 != null) {
            return root2;
        }

        // If both exist, Merge root2 into root1
        root1.val += root2.val;
        // Recursively merge the left and right subtrees
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}

// Time complexity: O(M+N)
// Space complexity: O(M+N) impove: use BFS
