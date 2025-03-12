class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        map = {}
        left = 0
        right = 0
        result = 0
        while right < len(s):
            if s[right] in map and map[s[right]] >= left:
                left = map[s[right]] + 1
            map[s[right]] = right
            result = max(result, right - left + 1)
            right += 1
        return result