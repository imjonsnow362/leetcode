class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //Initialise a list of list of integer to store all subsets 
        //Every list inside List is going to represent a subset
        List<List<Integer>> answer = new ArrayList<>();
        //I will call a recursive function that is going to generate all subsets 
        generateSubsets(nums, 0, new ArrayList<>(), answer);
        /*nums this will take the nums array , 0  the index we are currently on , new ArrayList<>() since we are going to store everything in the form of subset I am creating an arraylist , answer since we are going to store everything in answer  */
        return answer;
    }
    private void generateSubsets(int[] nums, int currentIndex, ArrayList<Integer> currentSubset, List<List<Integer>> answer){
        //we will start with the base condition 
        //base condition is when the index is not present in the array and we have processed all elements till last index it means we have found a subset 
        //Check notebook index 3 recursive tree for clarification
        if(currentIndex >= nums.length){
            answer.add(new ArrayList<>(currentSubset));
            return;
        }
        //If we are not hitting the base condition 
        // We will make two calls 
        
        //First call will be if we are going to consider the element 
        //If we consider the element we increment the index by 1 and add the element which is present in the index from which we incremented 
        //for example if we jumped from index 0 to 1 the element at index 0 will be added in the bracket check notebook for reference
        currentSubset.add(nums[currentIndex]);
        generateSubsets(nums, currentIndex+1, currentSubset, answer);
        //Second call will be if we are not going to consider the element
        //Since arraylist integer is pass by reference 
        //If i have changed something in the recursive function and then I am making a call 
        //In that case the subset is going to hold this value 
        //While coming out of the recursive function I need to delete this value 
        //Last element we have added needs to be removed 
        //Once I have returned from the recursive function I need to undo that change this is known as backtracking ⬆️
        //I am undoing the change of line 25 in line 34
        currentSubset.remove(currentSubset.size()-1);
        generateSubsets(nums, currentIndex+1, currentSubset, answer);
        return;
    }
}