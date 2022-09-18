class Solution {
    public int missingNumber(int[] nums) {
        int sumArr=0;
        //This will remove sum of all the elements present in the array except the missing number 
        for(int i=0; i<nums.length; i++){
            sumArr+=nums[i];
        }
        //1....n so we need to define n as length of array / last element in array 
        int n = nums.length;
        //formula 
        int expectedSum = (n*(n+1))/2;
        //we have got expected sum and array sum we just need to subtrract them 
        int requirednumber = expectedSum - sumArr;
        return requirednumber;
    }
}