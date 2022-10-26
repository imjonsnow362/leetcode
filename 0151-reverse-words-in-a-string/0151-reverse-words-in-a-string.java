class Solution {
    public String reverseWords(String s) {
        String str[] = s.split("\\s+");
        String ans = "";
        for (int i=str.length-1; i>=0; i--)
        {
            if(str[i] != " ") {
                 ans += str[i] + " ";
            } 
        }
        ans = ans.trim();
        return ans;
    }
}

