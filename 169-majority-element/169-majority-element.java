class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int res=0;
        int n = nums.length;
        for(int i=1; i<n; i++){
            if(nums[res]==nums[i])
                count++;
            else
                count--;
            
            if(count==0){
                count=1;
                res=i;
            }
        }
        
        count=0;
        for(int i=0;i<n;i++){
            if(nums[res]==nums[i])
                count++;
        }
        
        if(count>=(n/2))
            return nums[res];
        else
        return -1;
    }
}