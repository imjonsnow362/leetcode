class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        //Initialise List<int> answer 
        List<Integer> answer = new ArrayList<>();
        //sort array
        Arrays.sort(nums);
        
        int firstPosition = findfirstPosition(nums, target);
        
        if(firstPosition==-1)
            return answer;
        
        int lastPosition = findlastPosition(nums, target);
        
        //I want to put all the elements in a list 
        for(int i=firstPosition; i<=lastPosition; i++)
            answer.add(i);
        
        return answer;     
    }
    
    private int findfirstPosition(int[] nums, int target){
            int firstAnswerIndex=-1;
            int start=0;
            int end=nums.length-1;
            
            while(start <= end){
                int mid = start + (end-start)/2;
                if(nums[mid]== target){
                    end = mid-1;
                    firstAnswerIndex=mid;
                }
                else if(nums[mid] > target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            return firstAnswerIndex;
        }
    
    private int findlastPosition(int[] nums, int target){
            int lastAnswerIndex=-1;
            int start=0;
            int end=nums.length-1;
            
            while(start <= end){
                int mid = start + (end-start)/2;
                if(nums[mid]==target){
                    start = mid + 1;
                    lastAnswerIndex=mid;
                }
                else if(nums[mid] > target){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            }
            return lastAnswerIndex;
        }
}