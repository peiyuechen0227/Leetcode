/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        // Post-order traversal
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) {
            // If p and q does not be found
            return null;
        }else if(left == null && right != null) {
            // If p is found
            return right;
        }else if(left != null && right == null) {
            // If q is found
            return left;
        }else {
            // If both are found
            return root;
        }
    }
}
