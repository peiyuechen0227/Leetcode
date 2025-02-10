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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    TreeNode construct(int[] nums, int left, int right) {
        // Base case: If the left index exceeds the right index, return null (empty subtree).
        if (left > right) {
            return null;
        }

        // Find the index of the maximum value in the subarray
        int index = left;
        for (int i = left + 1; i < right + 1; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }

        // Create the root node with the maximum value
        TreeNode root = new TreeNode(nums[index]);

        // Recursively construct left and right subtrees
        root.left = construct(nums, left, index - 1);
        root.right = construct(nums, index + 1, right);
        return root;
    }
}
