class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Check page 172
        //Base case - if the array is empty
        if(strs.length==0) return "";
        //We will create a String named prefix and store the first string of the String array in this
        String prefix = strs[0];
        //We will iterate through the array till length of the array
        for(int i = 0; i<strs.length; i++){
            //While loop so whatever string is present at ith index we will check its index using indexOf prefix and we know that prefix starts from index 0 so 
            //If it is not equal to 0 so we will modify it 
            //Then we remove the substring and check which is the longest using start 0 and length of prefix - 1
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0, prefix.length() - 1);
                //if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}