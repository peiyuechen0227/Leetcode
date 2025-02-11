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
    // Store the mode through recurion
    ArrayList<Integer> resList;
    // Count the frequency through recursion
    int count = 0;
    // Maximum frequency
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        // Edge case: return null if root is null
        if (root == null) {
            return null;
        }
        resList = new ArrayList<>();
        getMode(root);
        // Convert the result list to an array
        int[] result = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            result[i] = resList.get(i);
        }
        return result;
    }

    void getMode(TreeNode root) {
        // Base case: return if root is null
        if (root == null) {
            return;
        }

        // Inorder traversal
        getMode(root.left);
        // The first node or the value is different from the previous node
        if (pre == null || pre.val != root.val) {
            // Reset count for new value
            count = 1;
        } else {
            // Increment count for duplicate values
            count++;
        }

        // Update mode tracking
        if (count == maxCount) {
            // If current value appears as frequently as maxCount, add it to the result
            resList.add(root.val);
        } if (count > maxCount) {
            // Clear previous results as a new max frequency is found
            resList.clear();
            resList.add(root.val);
            // Update maxCount
            maxCount = count;
        }
        // Update the previous node reference
        pre = root;
        getMode(root.right);
    }
}
