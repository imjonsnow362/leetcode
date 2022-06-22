class Solution {
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
