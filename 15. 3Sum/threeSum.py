class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()
        n = len(nums)

        for i in range(n - 2):  # Fixes off-by-one issue
            if nums[i] > 0:  # Optimization: if the first number is > 0, no need to continue
                break

            if i > 0 and nums[i] == nums[i - 1]:  # Skip duplicates for 'i'
                continue
            
            left, right = i + 1, n - 1

            while left < right:
                total = nums[i] + nums[left] + nums[right]

                if total == 0:
                    result.append([nums[i], nums[left], nums[right]])
                    
                    # Move left pointer past duplicates
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    # Move right pointer past duplicates
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    
                    left += 1
                    right -= 1
                
                elif total < 0:
                    left += 1
                else:
                    right -= 1

        return result