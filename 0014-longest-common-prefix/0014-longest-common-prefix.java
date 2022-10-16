class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Base case - if the array is empty
        if(strs.length==0) return "";
        //We will create a String named prefix and store the first string of the String array in this
        String prefix = strs[0];
        for(int i = 0; i<strs.length; i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}