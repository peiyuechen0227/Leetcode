class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        need, window = {}, {}
        left, right, valid = 0, 0, 0
        result = []
        for c in p:
            need[c] = need.get(c, 0) + 1
        while right < len(s):
            c = s[right]
            right += 1
            if c in need:
                window[c] = window.get(c, 0) + 1
                if window[c] == need[c]:
                    valid += 1

            if right - left >= len(p):
                if valid == len(need):
                    result.append(left)
                d = s[left]
                left += 1
                if d in window:
                    if window[d] == need[d]:
                        valid -=1
                    window[d] -= 1
        
        return result