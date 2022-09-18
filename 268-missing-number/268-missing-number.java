class Solution {
    public int missingNumber(int[] nums) {
        int sumArr=0;
        
        for(int i=0; i<nums.length; i++){
            sumArr+=nums[i];
        }
        
        int n = nums.length;
        
        int expectedSum = (n*(n+1))/2;
        //we have got expected sum and array sum we just need to subtrract them 
        int requirednumber = expectedSum - sumArr;
        return requirednumber;
    }
}