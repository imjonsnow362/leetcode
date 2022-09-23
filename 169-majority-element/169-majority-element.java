class Solution {
    public int majorityElement(int[] nums) {
        //Check Page 151
        //Step 1 
        //By making res is equal to 0 we are assuming that element at 0 index is majority 
        int res=0;
        //Because 0th index is element is considered majority we need to keep count as 1 
        int count = 1;
        int n = nums.length;
        //Iterate through the array to find if elements in the array are equal to majority
        for(int i=1; i<n; i++){
            if(nums[res]==nums[i])
                count++;
            else
                count--;
            //If the count reaches 0 we increase count to 1 and change the index of res to the currentElement 
            if(count==0){
                count=1;
                res=i;
            }
        }
        //Step 2
        //After we know majority we need to make sure that majority is actually the majority element in the array so we cross check with every element in the array and increase count
        count=0;
        for(int i=0;i<n;i++){
            if(nums[res]==nums[i])
                count++;
        }
        //If the count is greater than n/2 we need to return the element at which res is pointing to (which is majority) otherwise return -1
        if(count>=(n/2))
            return nums[res];
        else
        return -1;
    }
}