class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //PAGE 215
        //Recursive DFS Method
        //Initialise basic variables 
        int sum=0,maxNum=0;
        for(int i=0; i<nums.length; i++){
            //we will calculate the sum find the target and to find whether it is possible to divide the array or not 
            sum+=nums[i];
            maxNum=Math.max(maxNum,nums[i]);
        }
        //Base
        if(sum%k!=0 || maxNum > sum/k) return false;
        //Call helper function which is our DFS (this is going to explore every number to find its pair)
        return helper(nums,k,sum/k,0,new boolean[nums.length],0);
    }
    
    private boolean helper(int[] nums,int k,int targetSum, int curSum, boolean[] visited, int index){
        //visited array to keep track of elements we have used in pair 
        //targetSum is sum/k 20/4=5 so each subset sum should be 5 
        //index is to start from 0th index and go til last index
        //Base if k is 0 that means we have found all subsets and we will return true (After finding subset we reduce value of k by 1 and keep finding pairs till we get value of k as 0 check page 215)
        if(k==0) return true;
        if(curSum > targetSum) return false;
        //If curSum is equal to targetSum that means we have found our new susbet
        if(curSum == targetSum)
            //recursively call the function helper
            //curSum will be set to 0 after finding a subset
            return helper(nums,k-1,targetSum,0,visited,0);
        //we are going to iterate the input array and every time we are going to consider each element if it is not already visited
        //if it is already visited we are simply going to iterate to the next element 
        for(int i=index; i<nums.length; i++){
            if(!visited[i]){
                //if it is not visited we move to next element 
                //we will mark that true because we are visiting that element and we are going to find its pair  
                visited[i] = true;
                //add sum to the curSum (if pair works return true)
                if(helper(nums,k,targetSum,curSum+nums[i],visited,i+1)) return true;
                //if pair doesnt work we are going to reset it back to false [backtrack]
                visited[i]=false;
            }
        }
        //finally if k doesnt reach 0 after doing all this that means it doesnt have k equal sum subset
        //so return false
        return false;       
    }
}