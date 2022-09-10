class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            
            if(nums[mid]==target)
                return mid;
                
            //if the below condition is true that means the left half is sorted 
            if(nums[mid] >= nums[start]){
                //Now we need to check whether the element is present in the left half or not
                //This will compare the smallest element < target < highest element
                //If the below condition is the case then we go to left division
                if(nums[start] <= target && nums[mid] > target)
                    end = mid - 1;
                else
                    //otherwise move in the right half 
                    start = mid + 1;
                //check whether right half is sorted or not
            }else{
                if(nums[mid] < target && nums[end] >= target)
                start = mid + 1;   
                
                else 
                    end = mid - 1;
            }
        }
        return -1;
    }
}