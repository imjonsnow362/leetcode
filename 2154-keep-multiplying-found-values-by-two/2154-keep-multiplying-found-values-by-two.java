class Solution {
    public int findFinalValue(int[] nums, int original) {
       //iterate through the input array nums from 'start to end' left to right 
       for (int i = 0; i < nums.length; i++) {
           //check if array element is equal to the target original 
           if (nums[i] == original) {
                //if it is equal multiply it by 2 and store it
                original *= 2;
                //reset the value of i to 0 for next iteration 
                //here I will increase with i++ 
                //so we cannnot set the value of i=0 
                //it will give an error 
                //(basically it will not scan the element which is at index 0 )
                i = -1;
           }
       }
       //return the number which is stored in the variable original
       return original;
    }
}


/*
My solution 
class Solution {
    public int findFinalValue(int[] nums, int original) {
    for(int i=0;i<nums.length;i++){
			if(i==original){
				original = nums[i]*2
				System.out.println(original);
			}
			else if(i!=original && nums[i]*2!=arr[j]){
				return false;
			}
		}
    }
    }
}
*/