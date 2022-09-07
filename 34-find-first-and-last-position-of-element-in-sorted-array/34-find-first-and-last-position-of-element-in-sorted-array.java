class Solution {
    public int[] searchRange(int[] nums, int target) {
        //put corner case since we want 2 positions so we will check if there are any elements present in the array 
        if(nums.length < 1)
            //if there are no elements present then just return -1,-1
            return new int[]{-1, -1};
        
        int[] answer = {-1, -1};
        //code function for first position 
        answer[0] = findFirstPosition(nums, target);
        answer[1] = findLastPosition(nums, target);
        
        return answer;
    }
    private int findFirstPosition(int[] nums, int target){
        //initialise answer index with -1 initially 
        int answerIndex = -1;
        //initialise start and end
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            
            //comparison part 
            if(nums[mid]==target){
                //if the mid is equal to target I will update my answer index to mid 
                answerIndex = mid;
                //if I get mid is equal to target I continue my binary search in left part so 
                //update end to mid -1
                end = mid-1;
            }
            else if(nums[mid] > target){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }
        return answerIndex;
    }
    
    private int findLastPosition(int[] nums, int target){
        //initialise answer index with -1 initially 
        int answerIndex = -1;
        //initialise start and end
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            
            //comparison part 
            if(nums[mid]==target){
                //if the mid is equal to target I will update my answer index to mid 
                answerIndex = mid;
                //if I get mid is equal to target I continue my binary search in right part so 
                //update start to mid +1
                start = mid+1;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return answerIndex;
    }
}