class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        left, right = 0, 1
        while right < len(nums):
            if nums[right] != nums[left]:
                left += 1
                nums[left] = nums[right]
            right += 1
        return left + 1