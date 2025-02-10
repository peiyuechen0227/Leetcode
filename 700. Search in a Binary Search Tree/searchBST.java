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
    // public TreeNode searchBST(TreeNode root, int val) {
    //     // Base case: If root is null, return null
    //     if (root == null) {
    //         return null;
    //     }

    //     TreeNode result = null;
    //     // Compare the value of the root and val
    //     if (root.val == val) {
    //         return root;
    //     } else if (root.val > val) {
    //         result = searchBST(root.left, val);
    //     } else if (root.val < val) {
    //         result = searchBST(root.right, val);
    //     }
    //     return result;
    // }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }

        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == val) {
                break;
            } else if (cur.val > val) {
                cur = cur.left;
            } else if (cur.val < val) {
                cur = cur.right;
            }
        }
        return cur;
    }
}
