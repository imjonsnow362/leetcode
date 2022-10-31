class Solution {
    //Mapping keys 0 and 1 are not mapped to anything so we will leave it blank 
    private static final String[] KEYS_MAPPING = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        //Create a list of string to store ans 
        List<String> ans = new ArrayList<>();
        
        //Corner case - 
        if(digits.length() == 0)
            return ans;
        
        generateCombinations(digits, 0, "", ans);
        return ans;
    }
    //void because we are not returning anything 
    private void generateCombinations(String digits, int currentIndex, String currentString, List<String> ans){
        //Base case 
        if(currentIndex >= digits.length()){
            ans.add(currentString);
            //Since it is string (pass by value) so I dont need to create anything so directly return 
            return;
        }
        Character currentChar = digits.charAt(currentIndex);
        //Otherwise get all mapping 
        //This will return a character so we need to convert it into form of integer using -'0;
        String letters = KEYS_MAPPING[currentChar-'0'];
        //Iterate on everything
        for(int i=0; i<letters.length(); i++){
            generateCombinations(digits, currentIndex+1, currentString + letters.charAt(i), ans);   
        }
        return;
    }
}