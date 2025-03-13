from typing import List
class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        left = 0
        right = 0
        zero = 0
        result = 0
        while right < len(nums):
            if nums[right] == 0:
                zero += 1
            while zero > 1:
                if nums[left] == 0:
                    zero -= 1
                left += 1
            result = max(result, right - left)
            right += 1
        
        return result