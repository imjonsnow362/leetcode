class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        HashMap<Character, Integer> memo = new HashMap<>();
        int release = 0;
        
        for(int i=0; i < s.length(); i++){
            Character currentchar = s.charAt(i);
            //i is acquire
            //while(release < i && memo.containsKey(currentchar)){
                //delete a currentCharacter 
              //  Character disChar = s.charAt(release);
              //  memo.remove(disChar);
              //  release += 1;
           // }
            
            if(memo.containsKey(currentchar) && memo.get(currentchar) >= release)
               release = memo.get(currentchar) + 1;
            
            memo.put(currentchar, i);
            answer = Math.max(answer, i-release+1);
        }
        return answer;
    }
}