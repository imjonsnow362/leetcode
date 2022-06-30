class Solution{
   public int findCircleNum(int[][]graph){
       //first lets find out the number of cities that means the number of vertices 
        int n = graph.length;
       //this will store the number of provinces
        int answer = 0;
        //Initialise a visited array
        boolean[] visited = new boolean[n];
       //I want to run a DFS for all the vertices  
        for(int currentCity = 0; currentCity<n; currentCity++){
            //I will check whether my currentcity is visited or not 
            if(visited[currentCity]== false){
                //starting point is n 
                dfs(graph, currentCity, n, visited);
                //when coming out of this dfs function we know we have got a connected component
                answer += 1;
            }
        }
       //finally after this for loop I will get all the connected components so I will return them
        return answer;
   }
    //Writing DFS function below
   private void dfs(int[][] graph,int currentCity, int n, boolean[] visited){
        
       if(visited[currentCity])
           return;
       
       visited[currentCity] = true;
       int[] neighbours = graph[currentCity];
       
       for(int i=0; i<n; i++){
           //If value is 1 I will simply run a DFS
            if(neighbours[i]==1)
                dfs(graph,i,n,visited);
       }
        return;
   }
}
                