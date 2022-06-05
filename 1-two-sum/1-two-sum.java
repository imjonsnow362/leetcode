class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int currentVal = nums[i];
            int comp = target - currentVal;
            
            if(memo.containsKey(comp)){
                int arr[] = {i, memo.get(comp)};
                return arr;
            }            
            
            memo.put(currentVal, i);
            
        }
        return new int[2];
    }
}