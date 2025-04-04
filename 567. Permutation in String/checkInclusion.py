class Solution:
    # def checkInclusion(self, s1: str, s2: str) -> bool:
    #     length = len(s1)
    #     s = ''.join(sorted(s1))
    #     left = 0
    #     for right in range(len(s1), len(s2) + 1):
    #         s_sub = s2[left:right]
    #         if ''.join(sorted(s_sub)) == s:
    #             return True
    #         else:
    #             left += 1
    #     return False
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        fre_count1 = {}
        fre_count2 = {}
        for ch in s1:
            fre_count1[ch] = fre_count1.get(ch, 0) + 1
        for ch in s2[0:len(s1)]:
            fre_count2[ch] = fre_count2.get(ch, 0) + 1
        if fre_count1 == fre_count2:
            return True
        for i in range(len(s1), len(s2)):
            if fre_count2[s2[i - len(s1)]] == 1:
                fre_count2.pop(s2[i - len(s1)])
            else:
                fre_count2[s2[i - len(s1)]] -= 1
            fre_count2[s2[i]] = fre_count2.get(s2[i], 0) + 1

            if fre_count1 == fre_count2:
                return True
        
        return False