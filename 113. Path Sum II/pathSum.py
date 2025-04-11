# Definition for a binary tree node.
from typing import List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def pathSum(self, root:TreeNode, targetSum: int) -> List[List[int]]:
        result = []
        path = []

        def findPath(root: TreeNode, targetSum):
            if not root:
                return
            path.append(root.val)
            if not root.left and not root.right and targetSum == root.val:
                result.append(list(path))
            findPath(root.left, targetSum - root.val)
            findPath(root.right, targetSum - root.val)
            path.pop()
        
        findPath(root, targetSum)
        return result
    
# Example usage:
if __name__ == "__main__":
    # Create a sample binary tree
    root = TreeNode(5)
    root.left = TreeNode(4)
    root.right = TreeNode(8)
    root.left.left = TreeNode(11)
    root.left.left.left = TreeNode(7)
    root.left.left.right = TreeNode(2)
    root.right.left = TreeNode(13)
    root.right.right = TreeNode(4)
    root.right.right.left = TreeNode(5)
    root.right.right.right = TreeNode(1)

    targetSum = 22

    # Create an instance of Solution and call the method
    solution = Solution()
    result = solution.pathSum(root, targetSum)

    # Print the result
    print(result)  # Output: [[5, 4, 11, 2], [5, 8, 4, 1]]