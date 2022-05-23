class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> memo = new HashMap<Integer, Boolean>();
            for(int currentNums: nums1){
                if(!memo.containsKey(currentNums))
                    memo.put(currentNums, true);
            }
                    
            ArrayList<Integer> answer = new ArrayList<>();
            for(int currentNums: nums2){
                    if(memo.containsKey(currentNums) && memo.get(currentNums)){
                        answer.add(currentNums);
                        memo.put(currentNums, false);
                    }
            }   
                
                int[] result = new int[answer.size()];
                for(int i=0; i<answer.size(); i++){
                    result[i]  = answer.get(i);
                }
        return result;
            }
}
