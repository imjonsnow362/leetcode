//we are getting a time limit exceeded error in this so we need to use hash map
class Solution {
	public int climbStairs(int n){
	//we are using hash maps here are because it will decrease time complexity 
	//so in the recursive tree we have made we will notice that they are many repeating sub problems 
	//like if you check in the notebook when we jump 1 step at a time we eventually 
	//reach 3 before 4 (3 splits into +1 = 4 and +2 = 5) but 3 has repeated in the right leave
	// of the recursive tree when we reach two after adding 0+2 we can again expand during bottom up approach 
	//which gives 3 again and when we exapnd three with +1 +2 rule it gives the same answer 
	//3 and others might be repeating many times so we needto assign a key whose value will be 3 or 
	//any number that repeats a lot this will decrease the TC
	//hence fixing the problem 
	// this is called overlapping subproblem 
	//dynamic programming is nothing but storing the results of the sub problem so that 
	//when we encounter the problem again we cannot 
	//we will make a hash map with value stored for each step from 1-highest step 
	//e.g. from 3 there currentStair+1 = 4 ✅ but currentStair+2=5 which is ❌ 
	//so no of ways to reach n=4 is only 1 so we will store 1 in 3 key 
	//so when 3 repeats again we know 3's answer is 1 
	//--dynamic programming is an approach through which we optimise our overlapping subproblem --
	//I need to add hashmap to the main function hashmap works with keyvalue integer so 
	return totalWays(0,n, new HashMap<Integer, Integer>());
}
//naming the hashmap as memo 
    private int totalWays(int currentStair, int targetStair, HashMap<Integer, Integer> memo){
		if(currentStair == targetStair)
			return 1;
		if(currentStair > targetStair)
			return 0;
		//I need to add how the total ways it getting added 
		//oneJump has the condition currentStair+1 and for 2 it is different 


		//what variable keeps changing in this program - currentStair ✅ so 
		int currentKey = currentStair ;

		//we need to check if the sub problem is solved before or not so use if 
		if(memo.containsKey(currentKey))
			return memo.get(currentKey);
		//pass the memo hashmap here as well 
		//and if the subproblem hasn't been solved do this and get an answer ans store it with memo.put 
		int oneJump = totalWays(currentStair+1, targetStair, memo);
		int twoJump = totalWays(currentStair+2, targetStair, memo);

		memo.put(currentKey, oneJump + twoJump);
		return oneJump + twoJump;
	}	
}


/*
//brute force method using recursion 
class Solution{
	public int climbStairs(int n){
		//int n is the target stair 
		return TotalWays(0,n);
		//initially I am present on 0th stair 
		//and the stair I want to go to is n-th stair 
	}
	private int TotalWays(int currentStair, int targetStair){
		//now just need to convert my approach into code 
		if(currentStair == targetStair)
			return 1;
		if(currentStair > targetStair)
			return 0;
		//I need to add how the total ways it getting added 
		//oneJump has the condition currentStair+1 and for 2 it is different 
		int oneJump = TotalWays(currentStair+1, targetStair);
		int twoJump = TotalWays(currentStair+2, targetStair);
		//when we go back to the top from bottom (bottom up) we just add the oneJump and twoJump answer which can be either 0 or 1 because we did not reach the targetstair we wantr
        return oneJump+twoJump;
	}
}
*/