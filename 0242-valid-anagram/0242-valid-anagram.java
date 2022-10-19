class Solution {
    public boolean isAnagram(String s, String t) {
       //CLEAN CODE - 
        //Base case 
        if(s.length() != t.length()) return false;
        //Creating an array of 26 of alphabets
        int[] char_count = new int[26];
        //Iterate through s and store the count of each character
        for(int i=0; i<s.length(); i++){
            //Check and store the count of each character in s
            //s.charAt will get current Char in s and -'a' by doing s.charat(i)-a we will get the index of the character //so example we get a in s.charAt when we subtract -'a' we get 0 which is the correct index of a in the array (a is the first letter in alphabet at index 0)
            char_count[s.charAt(i)-'a']++;
            //Check and decrement the count of each character in t 
//Using this we can bring count of each character down to 0 that means it is leveled out and it is a valid anagram 
            char_count[t.charAt(i)-'a']--;
        }
        //We have to go through the integer array char_count and check count of each character has to be 0
        //If the count is 0 that means it is a valid anagram 
        for(int count : char_count){
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
        
        //COMPLEX CODE using HashMap- 
        /*
        //Applying base case that if the length of both input string is not same then just return false
        if(s.length() != t.length()){
            return false;
        }
        //Initialise a HashMap to store all the characters from Input String 
        HashMap<Character, Integer> memo = new HashMap<>();
        //Use a for loop and iterate through every character of input String s
        for(int i=0;i<s.length();i++){
            //iterate through every character of input String s
            char currentValue = s.charAt(i);
            //Add character in HashMap and put value as 1 as they are coming for the first time
            memo.put(currentValue, memo.getOrDefault(currentValue, 0) + 1);
            
        }
        //Use one more for loop to iterate throught String input t
        for(int i=0;i<t.length();i++){
            char currentValue = t.charAt(i);
            //
            if(memo.containsKey(currentValue)){
                int prevCount = memo.get(currentValue);
                //If the value of prevCount is still 1 after going through HashMap
                //then we remove that element because all the values for keys should be atleast 2 to be valid (This is an edge case)
                if(prevCount == 1){
                    memo.remove(currentValue);
                }
                else{
                    memo.put(currentValue, prevCount - 1);
                }
            }
            else{
                return false;
            }
        }
        
        return memo.size() == 0;
    
    }
}
*/