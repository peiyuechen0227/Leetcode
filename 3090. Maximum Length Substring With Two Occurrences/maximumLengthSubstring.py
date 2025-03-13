import sys
from collections import defaultdict

class Solution:
    def maximumLengthSubstring(self, s: str) -> int:
        left = 0
        right = 0
        result = 0
        map = defaultdict(int)
        while right < len(s):
            map[s[right]] += 1
            while (map[s[right]] > 2):
                map[s[left]] -= 1
                left += 1
            result = max(result, right - left + 1)
            right += 1
        return result