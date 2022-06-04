class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Initialise a list<list<Integer>>
        List<List<Integer>> answer = new ArrayList<>();
        //Call a recursive function which will generate all the solutions 
        //candidates is currentIndex from recursive tree 
        //index will be 0 , target , since I want to generate all the solutions I will store those solutions in a list of Integers and finally all solutions will be stored in the original list which is "answer"
        generateCombinations(candidates, 0, target, new ArrayList<Integer>(), answer);
        //once answer is populated we will return it 
        return answer;
    }
     private void generateCombinations(int[] nums, int currentIndex, int target, ArrayList<Integer> current, List<List<Integer>> answer){
         //base case 
         if(target == 0){
             //if we keep answer.add(current); it will generate a blank list 
             //so we need to keep a copy we will create a new arraylist
             answer.add(new ArrayList<>(current));
             return; 
        }
         //if we dont have any element left to process 
         if(currentIndex >= nums.length)
             return;
         //first choice - consider 
         if(nums[currentIndex] <= target){
             current.add(nums[currentIndex]);
             //make a call to the function , target - numscurrentindex is in example recursive tree - 4-2, 2-2 etc check page
             generateCombinations(nums, currentIndex, target - nums[currentIndex], current, answer);
             //undo the change - remove the element we have added last
             current.remove(current.size()-1);
         }
         //not consider 
         //in this case we move to the next index so currentIndex+1 , and target will stay constant
         generateCombinations(nums, currentIndex+1, target, current, answer);
         return;
     } 
}