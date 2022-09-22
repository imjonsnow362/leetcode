class Solution {
    public static void swap(int[] nums, int i, int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        
        while(mid <= high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(nums,mid,high);
                high--;
            }
        }
    }
}