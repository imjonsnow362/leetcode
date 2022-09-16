class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int duplicateCount=0;
        for(int i=1; i<n; i=i+1){
            if(nums[i] == nums[i-1])
                duplicateCount = duplicateCount + 1;
            else
            nums[i-duplicateCount] = nums[i]; 
            }
        return n - duplicateCount;
}
}