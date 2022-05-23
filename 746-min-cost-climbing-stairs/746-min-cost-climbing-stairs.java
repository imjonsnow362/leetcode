class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> memo = new HashMap<>(); 
        return Math.min(minCost(cost, 0, memo), minCost(cost, 1, memo));
            //cost,0 means start from 0 index and cost 1 means start from first index 
    }

    private int minCost(int[] cost,int currentIndex, HashMap<Integer, Integer> memo){
        //if my current index has reached the last index which is not in the array then we return 0
        //for e.g. 10,15,20 and the index after 20 so thats why we write cost.length 
        if(currentIndex == cost.length)
            return 0;
        //when the currentIndex is at 1 index more than lenght of index 
        //we cannot go back / - to reach to the length of index that is last index 
        // we need to use Integer.max to automatically reject the index 
        //So here instead of writing Int_Max we can check max valure of an array which is 1000 in the 
        //constraint of the question - we need to put 1001 
        if(currentIndex > cost.length)
            return 1001;
        int currentKey = currentIndex;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int oneJump = cost[currentIndex] + minCost(cost, currentIndex+1, memo);
        int twoJump = cost[currentIndex] + minCost(cost, currentIndex+2, memo);
        memo.put(currentKey, Math.min(oneJump, twoJump));
        return memo.get(currentKey);
    }
}