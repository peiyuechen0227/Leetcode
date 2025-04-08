class Solution:
    def minWindow(self, s: str, t: str) -> str:
        need, window = {}, {}
        left, right, valid = 0, 0, 0
        length = 100001
        for c in t:
            need[c] = need.get(c, 0) + 1
        while right < len(s):
            c = s[right]
            right += 1
            if c in need:
                window[c] = window.get(c, 0) + 1
                if window[c] == need[c]:
                    valid += 1
            
            while valid == len(need):
                if right - left < length:
                    start = left
                    length = right - left
                d = s[left]
                left += 1
                if d in need:
                    if window[d] == need[d]:
                        valid -= 1
                    window[d] -= 1
        
        if length == 100001:
            return ""
        else: 
            return s[start:start + length]
        
if __name__ == "__main__":
    s = "ADABCDFSWEAABC"
    t = "AABC"
    solution = Solution()
    result = solution.minWindow(s,t)
    print(result)