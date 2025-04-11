# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # def flatten(self, root: Optional[TreeNode]) -> None:
    #     """
    #     Do not return anything, modify root in-place instead.
    #     """
    #     self.pre = None
    #     def dfs(root):
    #         if root is None:
    #             return
    #         dfs(root.right)
    #         dfs(root.left)
            
    #         root.right = self.pre
    #         root.left = None
    #         self.pre = root
        
    #     dfs(root)

    def flatten(self, root: Optional[TreeNode]) -> None:
        if root is None:
            return
        stack = [root]
        pre = None
        while stack:
            node = stack.pop()
            if pre:
                pre.left = None
                pre.right = node
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
            
            pre = node