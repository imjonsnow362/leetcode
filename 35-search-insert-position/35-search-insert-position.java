class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        
        int correctIndex = -1;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            //return the index if the target is found(from description)
            if(nums[mid] == target)
                return mid;
            //if the mid is smaller than target 
            if(nums[mid] < target){
                start = mid +1;
        }else{
                //if nums[mid] > target 
                //then it is possible nums[mid] is the correctIndex
            correctIndex = mid;
                //and move to the left division 
            end = mid -1;
        }
    }
        //covering corner case
        //check page 110 for corner case explanation
    if(correctIndex==-1)
        return nums.length;
    return correctIndex;
    }
}