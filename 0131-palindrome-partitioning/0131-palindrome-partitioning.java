class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        //need a recursive function to generate all possible combinations 
        generateAllCombos(s, 0, s.length()-1, new ArrayList<String>(), result);
        return result;
    }
    
    private void generateAllCombos(String s, int start, int end, ArrayList<String> currentConf, List<List<String>> result){
        //Base condition 
        if(start > end){
            result.add(new ArrayList<String>(currentConf));
            return;
        }
        
        for(int i=start; i<=end; i++){
            String leftPart = s.substring(start, i+1);
            
            if(isPalindrome(leftPart)){
                currentConf.add(leftPart);
                generateAllCombos(s, i+1, end, currentConf, result);
                currentConf.remove(currentConf.size()-1);
            }
        }
        return;
    }
    
    private boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        
        while(left <= right){
            if(s.charAt(left) != s.charAt(right))
               return false;
               
               left += 1;
               right -= 1;
        }
               return true;
    }
}