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
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBST(nums, 0, nums.length);

    }
    TreeNode arrayToBST(int[] nums, int low, int high) {
        // Base case: If the subarray is empty, return null.
        if (low >= high) {
            return null;
        }

        // Find the middle index.
        int mid = low + (high - low)/2;

        // Create a new node with mid element.
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively construct left and right subtrees.
        root.left = arrayToBST(nums, low, mid);// Left subtree from [low, mid)
        root.right = arrayToBST(nums, mid + 1, high);// Right subtree from [mid+1, high)
        return root;
    }
}