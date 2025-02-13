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
    // Recursion
    // Track the previous node
    //TreeNode pre;
    // public TreeNode convertBST(TreeNode root) {
    //     // Initialize previous node to null
    //     pre = null;
    //     convert(root);
    //     // Return the transformed tree
    //     return root;
    // }

    // void convert(TreeNode root) {
    //     // Base case: if root is empty, return
    //     if (root == null) {
    //         return;
    //     }

    //     // Traverse the right subtree first (reverse in-order traversal)
    //     convert(root.right);

    //     // Update the current node's value by adding the value of the previous node
    //     if (pre != null) {
    //         root.val += pre.val;
    //     }
    //     // Mark the current node as the previous node for the next iteration
    //     pre = root;

    //     // Traverse the left subtree
    //     convert(root.left);
    // }

    // Iterative method
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            // Traverse the right subtree
            while (node != null) {
                stack.push(node);
                node = node.right;
            }

            // Process the top node
            node = stack.pop();
            sum += node.val;
            node.val = sum;


            // Move to the left node
            node = node.left;
        }

        return root;
    }
}
