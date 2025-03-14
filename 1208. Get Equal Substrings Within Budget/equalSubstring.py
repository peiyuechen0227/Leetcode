class Solution:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        left = right = maxLength = cost = 0
        while right < len(s):
            cost += abs(ord(s[right]) - ord(t[right]))
            while cost > maxCost:
                cost -= abs(ord(s[left]) - ord(t[left]))
                left += 1
            maxLength = max(maxLength, right - left + 1)
            right += 1
        return maxLength