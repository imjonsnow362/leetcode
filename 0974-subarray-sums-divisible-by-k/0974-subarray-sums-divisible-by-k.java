class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        //PAGE 226
        int answer = 0;
        int prefixSum = 0;
        
        HashMap<Integer, Integer> memo = new HashMap<>();
        //to handle corner cases I will create an entry for pS 0
        memo.put(prefixSum, 1);
        
        //startr iterating over nums array 
        for(int currentVal: nums){
            prefixSum += currentVal;
            //we need to handle cases for negative value (we need to make them positive)
            int currentRem = ((prefixSum % k)+k)%k;
            
            if(memo.containsKey(currentRem)){
                answer += memo.get(currentRem);
                memo.put(currentRem, memo.get(currentRem)+1);
            }else{
                memo.put(currentRem, 1);
            }
        }
        return answer;
    }
}