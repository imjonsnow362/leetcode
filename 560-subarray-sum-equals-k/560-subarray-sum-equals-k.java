class Solution {

    public int subarraySum(int[] nums, int k) {
        //Initialise answer variable here 
        int answer = 0;
        //Initialise prefixSum variable here 
        int prefixSum = 0;
        
        //Initialise HashMap here 
        HashMap<Integer, Integer> memo = new HashMap<>();
        //create an entry in the map 
        memo.put(prefixSum, 1);
        //Iterate over nums array 
        for (int currentVal : nums) {
            //We will add this to the prefix sum (What we are doing in step 3 of procedure on page 143) 
            
            prefixSum += currentVal;
            //Check if prefix sum - k is present in the map or not
            if (memo.containsKey(prefixSum - k)) 
                //If the key is already present in the map we will increment answer by 1.
                answer += memo.get(prefixSum - k);
            //Otherwise come outside the previous if and check whether prefixSum is present in the map or not 
            if (memo.containsKey(prefixSum)) 
                //If the ps and key is already present I will not make a new entry I will increase frequency by 1 
                memo.put(prefixSum, memo.get(prefixSum) + 1); 
            //Else part the key is not present in the memo that means the pS is coming first time 
            else 
                memo.put(prefixSum, 1);
        }
        //Outside return the answer variable 
        return answer;
    }
}
