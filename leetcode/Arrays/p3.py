class Solution:
    """https://leetcode.com/problems/longest-substring-without-repeating-characters/"""
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) <=2:
            return len(set(s))
        start = 0
        end = 1
        max_ = 0
        indx = {}
        s_start = s[start]
        indx[s_start] = [start]
        while end < len(s):
            s_start = s[start]
            s_end = s[end]
            if s_end in indx.keys():
                last_indx = indx[s_end][-1]
                if last_indx > start or s_start == s_end:
                    max_ = max(max_,end - start)
                    start = last_indx+1
            else:
                indx[s_end] = []
            indx[s_end].append(end)
            end +=1
        return max(max_,end-start)
                    
            