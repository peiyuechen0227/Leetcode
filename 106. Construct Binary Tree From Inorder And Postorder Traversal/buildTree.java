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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Base case: If the traversal arrays are empty, return null
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        // Root node is the last element in postorder
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);

        // If only one element, return the root (leaf node case)
        if (postorder.length == 1) {
            return root;
        }

        // Find root index in inorder traversal
        int index = 0;
        for (index = 0; index < inorder.length; index++) {
            if (inorder[index] == rootVal) {
                break;
            }
        }
        // Split inorder and postorder arrays based on root index
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, index);
        int[] rightPostorder = Arrays.copyOfRange(postorder, index, postorder.length - 1);

        // Recursively build left and right subtrees
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);

        return root;
    }
}
