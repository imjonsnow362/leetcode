// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	//Initialise an indegree and outdegree
        //The size of this indegree array and outdegree array will be n+1 
        //because the array of people which is n = 4 starts from 1,2,3,4 
        //we will start the array from 0,1,2,3,4 so then we have one extra index so we will put n+1
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        //we will iterate over our array 
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(M[i][j]==1){
                inDegree[j]+=1;
                outDegree[i]+=1;
                }
            }
        }
            // int a = currentTrust[0];
            // int b = currentTrust[1];
            // //When a is trusting b Indegree of b will increase
            // //And outdegree of a will increase 
            // inDegree[b] += 1;
            // outDegree[a] += 1;
        //When it is populated completely 
        //I need to iterate over those n people
         for(int currentPeople = 0; currentPeople < n; currentPeople++){
            //check the condition for town judge  
             //indegree[currentPeople]  == n-1 this means that we have all these incoming edges towards this person 
             //if this condition is true return the town judge
             if(inDegree[currentPeople] == n-1 && outDegree[currentPeople] == 0)
                 return currentPeople;
        }
        //if we are not finding the town judge after this for loop return -1
         return -1;
    }
}

/*class Solution {
    public int findJudge(int n, int[][] trust) {
        //Initialise an indegree and outdegree
        //The size of this indegree array and outdegree array will be n+1 
        //because the array of people which is n = 4 starts from 1,2,3,4 
        //we will start the array from 0,1,2,3,4 so then we have one extra index so we will put n+1
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        //we will iterate over our array 
        for(int[] currentTrust: trust){
            int a = currentTrust[0];
            int b = currentTrust[1];
            //When a is trusting b Indegree of b will increase
            //And outdegree of a will increase 
            inDegree[b] += 1;
            outDegree[a] += 1;
        }
        //When it is populated completely 
        //I need to iterate over those n people
         for(int currentPeople = 1; currentPeople <= n; currentPeople++){
            //check the condition for town judge  
             //indegree[currentPeople]  == n-1 this means that we have all these incoming edges towards this person 
             //if this condition is true return the town judge
             if(inDegree[currentPeople] == n-1 && outDegree[currentPeople] == 0)
                 return currentPeople;
        }
        //if we are not finding the town judge after this for loop return -1
         return -1;
    }
 }
 */
