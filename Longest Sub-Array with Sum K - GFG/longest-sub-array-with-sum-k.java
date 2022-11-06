//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
   
    // Function for finding maximum and value pair
    public int lenOfLongSubarr (int nums[], int N, int k) {
        //Complete the function
        //Initialise answer variable here 
        int answer = 0;
        //Initialise prefixSum variable here 
        int prefixSum = 0;
        
        //Initialise HashMap here 
        HashMap<Integer, Integer> memo = new HashMap<>();
        //create an entry in the map 
        //we want the index so initialise this -1
        memo.put(prefixSum, -1);
        //Iterate over nums array 
        for (int i=0; i<N; i++) {
            //We will add this to the prefix sum (What we are doing in step 3 of procedure on page 143) 
            
            prefixSum += nums[i];
            //Check if prefix sum - k is present in the map or not
            if (memo.containsKey(prefixSum - k)) 
                //If the key is already present in the map we will increment answer by 1.
                answer = Math.max(answer, i - memo.get(prefixSum - k));
            //If memo doesnt contain key so add it  
            if (!memo.containsKey(prefixSum)) 
                memo.put(prefixSum, i);
        }
        //Outside return the answer variable 
        return answer;
    }
}


