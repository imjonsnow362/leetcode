class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            if(nums[mid]==target)
                return true;
            
            while(start < mid && nums[mid] == nums[start])
                start=start+1;
            
            if(nums[start] <= nums[mid]){
                
                if(nums[start] <= target && nums[mid] > target)
                    end = mid - 1;
                else
                    //otherwise move in the right half 
                    start = mid + 1;
                //check whether right half is sorted or not
            }else{
                //this will check whether the element is lying in between mid and end or not 
                if(nums[mid] < target && nums[end] >= target)
                    //move to the right half
                start = mid + 1;   
                //otherwise move to the left half 
                else 
                    end = mid - 1;
            }
        }
        return false;    
    }
}