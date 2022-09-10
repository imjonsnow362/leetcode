class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        
        if(nums[start] <= nums[end])
            return nums[0];
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            if(nums[mid] > nums[mid +1])
                return nums[mid+1];
            
            if(nums[mid] < nums[mid-1]){
                return nums[mid];
                //otherwise I will check which part of the array is sorted
                //and then move to the part which is unsorted
            }
            if(nums[mid] >= nums[start])
                //if the above condition satisfies we move to the other half because this half is sorted 
                //the min element will always be in unsorted part 
                start = mid + 1;
                else
                end = mid - 1;
        }
        return -1;
    }
}