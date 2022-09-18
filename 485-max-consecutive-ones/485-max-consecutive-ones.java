class Solution{
	public int findMaxConsecutiveOnes(int[] nums){
	//initialise and declare a variable here to
	//keep track of how many ones you have seen in a row 
	int count=0;
	int max=0;
	for(int i=0; i<nums.length; i++){
	///do something with elements nums[i].
		if(nums[i]==1){
			count++;
		}
		else{
			count=0;
		}
		max= Math.max(max,count);
	}
	return max;
	}
}

