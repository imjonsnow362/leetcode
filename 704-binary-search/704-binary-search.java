class Solution {
    public int search(int[] nums, int target) {
        //Initialise start with first index i.e. 0 
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            //comparison
            if(nums[mid]==target)
                return mid;
            //decide 
            if(nums[mid] > target)
                end = mid - 1;
            
            else
                start = mid + 1;
        }
        return -1;
    }
}