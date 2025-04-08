class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        window = {}
        left, right, result = 0, 0, 0
        while right < len(nums):
            element = nums[right]
            right += 1
            window[element] = window.get(element, 0) + 1

            while window[element] > k:
                ele_delete = nums[left]
                left += 1
                window[ele_delete] -= 1
            
            result = max(result, right - left)

        return result