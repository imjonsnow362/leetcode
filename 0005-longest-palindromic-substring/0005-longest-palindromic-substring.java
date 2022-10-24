class Solution {
    public String longestPalindrome(String s) {
        //If it is an empty string or less than 1 then we return blank 
        if(s == null || s.length() < 1) return "";
        //Starting and ending boundary - This is the boundaries from which we grab a final substring at the end to return from
        int start=0;
        int end=0;
        //We are going to adjust these boundaries based on the palindrome
        //We are iterating through the string letter by letter
        for(int i=0; i<s.length(); i++){
            //We will handle two cases - Case where the one special middle character doesnt have a match ("racEcar") and other case is where the string is a palindrome ("abba")
            //Why we are passing i both times ? - in case of racEcar once we call function here it will check if left is equal to right so since i is passed two times it is pointing at the middle element E (so E = E) 
            int len1 = expandFromMiddle(s, i, i);
            //left pointer will be i and right pointer will be i+1 (aaaabbaaaa) left will point to b and right will point to the b to the right and expand from there 
            int len2 = expandFromMiddle(s, i, i+1);
            
            //After this we just need the maximum length because we need the longest palindrome
            int len = Math.max(len1, len2);
            //If length is greater than boundary of substring 
            //That means we found a new longer substring - "[[bab]](smaller length)  [baab] bigger length"
            //Then we will have to adjust the boundaries 
            if(len > end - start){
                //Index we are at is going to be the center of a substring of a palindrome 
                //Start is gonna have to be subtracting the length divide by 2 
                //End is gonna be adding the length divide by 2 
                //We are doing -1 here to prevent index out of bounds 
                //This will take that palindromes length and the starting boundary will get set to the index of middle 
                //for racecar - 
                //length of racecar is 7 and we have found a new longest palindrome and we return that we found it at index 3 (e) then we divide 7 by 2 and put our starting boundary to the left and right boundary to the right 
                start = i - ((len-1) / 2);
                end = i + (len / 2);
                
            }
        }
        //+1 will also prevent index out of bounds error
        return s.substring(start, end + 1);
        
    }
    //This is going to return the length of the palindrome substring after we expand 
    //It will take String s , left boundary , right boundary as argument 
    public int expandFromMiddle(String s, int left, int right){
        //Base case
        if(s ==  null || left > right) return 0;
        //Here left is greater than or equal to index 0 and right is smaller than length of string 
        //And left should match right a=a b=b
        //Lets say I am on "abba" and my left is at index 1 and right is at index 2 so my while loop condition is satisfying 
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            //If condition meets expand
            left--;
            right++;
        }
        //When it breaks - that means When left != right or (acbbac) b=b but c!=a
        return right - left - 1;
    }
}