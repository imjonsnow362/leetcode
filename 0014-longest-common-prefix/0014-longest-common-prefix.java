class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Check page 172
        //Base case - if the array is empty
        if(strs.length==0) return "";
        //We will create a String named prefix and store the first string of the String array in this
        String prefix = strs[0];
        //We will iterate through the array till length of the array
        for(int i = 0; i<strs.length; i++){
            //While loop so whatever string is present at ith index we check it with prefix if the prefix is not matching we will remove letter from the end of the prefix using substring(0,n-1) method
            //We will keep on removing characters till the prefix and ith string match 
            //e.g. prefix = flower and array = ["flow"] so flower and flow dont match so we keep on reducing 1 character from the end flower̶ then again while loop is satisfying so again reduce 1 more char this time we get flowe̶r̶ now prefix and ith string are matching so we can go ahead to other words in the array to check whether they match the prefix or not and perform reduction if needed.
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0, prefix.length() - 1);
                //if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}