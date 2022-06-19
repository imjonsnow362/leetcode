class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return "1"
        
        if n == 2:
            return "11"
    
        s = "11"
        for i in range(2, n):
            count = 1
            string_new = ""
        for j in range(len(s)):
            if j == len(s) - 1:
                string_new = string_new + str(count) + s[j]
                break
            if s[j] == s[j+1]:
                count += 1
            else:
                string_new = string_new + str(count) + s[j]
                count = 1
                
            s = string_new
        return string_new
