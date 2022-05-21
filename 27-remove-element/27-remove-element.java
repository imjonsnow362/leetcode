class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // actual sequance index
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k += 1;
            }
        }
        return k; // now it points to the next actual sequence element. So no need to increase it.
    }
}
/*class Solution {
    public int removeElement(int[] nums, int val) {
        int length=nums.length;
        int k=0;
        for(int i=0;i<nums.length; i++){
            if(nums[i]==val){
                for(i=nums.length; i<nums.length; i++){
                    nums[i-1]=nums[i];
                    }
                length--;
                }
            return k;
            }
        }
    }
    */