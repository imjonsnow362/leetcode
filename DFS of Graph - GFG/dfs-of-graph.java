// { Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj =
                new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        //We want the answer in the form of arraylist of integer 
        ArrayList<Integer> answer = new ArrayList<>();
        //we need to mark everything as listed 
        boolean[] visited = new boolean[V];
        
        //call a function dfs 
        //dfs will take the graph adj
        //V is the number of vertices 
        //It is going to take starting point which is vertex 0 
        //visited array and answer array
        depthFirstSearch(adj, V, 0, visited, answer);
        //once the answer is populated we will return it 
        return answer;
    }
    
    private void depthFirstSearch(ArrayList<ArrayList<Integer>> adj, int V, int currentVertex, boolean[] visited, List<Integer> answer){
    
    //if the current vertex is already listed we dont need to do anything 
        if(visited[currentVertex])
            return;
        
        //if it is not visited I will mark the node as listed and 
        visited[currentVertex] = true;
        answer.add(currentVertex);
        //I will explore the neighbours 
        //e.g. To check the neighbours of second index we will just go to second index from the list
        //this will return the list of its neighbours (in case of list we use adj.get but otherwise we can use adj[2] 
        List<Integer> neighbours = adj.get(currentVertex);
        //Once we get the neighbour we need to iterate 
        for(int currentNeigh: neighbours)
            depthFirstSearch(adj, V, currentNeigh, visited, answer);
            
            return;
    }
}
