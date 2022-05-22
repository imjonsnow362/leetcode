class Solution {
    public boolean validMountainArray(int[] arr) {
        //using two pointers we will compare values side by side so 
        int i=0;
        //setting i to 0 to start from 0 index 
        //to compare two elements side by side we will use to iterate so 
        //i < arr.length && i+1 < arr.length we also have to give
        //the rule that in mountain array first element is smaller then the next element 
        //i++ to iterate (rule of while loop)
        while(i < arr.length && i+1 < arr.length && arr[i] < arr[i+1]){
            i++;
            }
            //there are two edge cases in this program other than the normal return true mountain array 
            //first is strictly increasing other strictly decreasing 
            //first if statement is for strcitly increasing 
            //i==0 is for never increasing 
            // || or 
            // next element is greate than or equal to the end of the array with length we reach end of the array 
            if(i == 0 || i + 1 >= arr.length){
                return false;
            }
            // for strictly or not strictly decreasing 
            // loop for strictly decreasing
            while(i < arr.length && i+1 < arr.length){
                // first element is lesser than the secodn element same with second wuthg next 
                if(arr[i] <= arr[i++ + 1]){
                    return false;
                }
            }
            return true;
        }
    }
