/*mysolutionclass Solution {
    public void moveZeroes(int[] nums) {
        int j=1;
        //j here is writepointer which will move 0 to the end of the array 
        //i will be used to read the array and check if the element is equal to 0 or not 
        for(int i=1; i<nums.length; i++){
            if(nums[i] == 0){
                nums[j] = nums[i];
                j--;
                //return index -- move element to the other side 
            }
        }
    }
}
*/

class Solution {
   public void moveZeroes(int[] nums) {
      int j = 0;
      for(int i=0; i < nums.length; i++) {
        if(nums[i] != 0) {
          nums[j++] = nums[i];
      }
    }
      for(int i=j; i < nums.length; i++) {
        nums[i] = 0;
      }
   }
}
