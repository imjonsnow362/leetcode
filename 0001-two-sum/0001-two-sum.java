class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Initialise a HashMap
        HashMap<Integer, Integer> memo = new HashMap<>();
        //iterate through the array 
        for(int i = 0; i < nums.length; i++){
            //currentVal is equal to the value present while iterating
            int currentVal = nums[i];
            //using formula a+b=target (Check Page 147 for explanation)
            //complement is a , currentVal is b
            int complement = target - currentVal;
            //Check if the complement is already present in the map or not
            if(memo.containsKey(complement)){
                //we need to return the answer in integer (we need to return the value at which the complement is coming and the currentIndex)
                return new int[]{memo.get(complement),i};
            }            
            //other wise if we havent encountered the value before we will add the value in the map 
            memo.put(currentVal, i);
        }
        return new int[2];
    }
}