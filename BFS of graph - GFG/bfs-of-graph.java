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
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        //we are initialising an arraylist of integer 
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[V];
        
        //initialise a queue 
        Queue<Integer> queue = new LinkedList<>();
        //We will add something in the queueu
        //We want to add the starting vertex that is vertex 0 
        queue.add(0);
        //Setting the condition here that until and unless thwe queue is not empty
        //In BFS case the queueu is not empty so we will dequeue the front element 
        while(!queue.isEmpty()){
            //I will remove the vertex 
            int currentVertex = queue.remove();
            //I will check whether the queue is already listed or not 
            if(visited[currentVertex])
            //if this above line is true then we dont need to do anything we just need to move on to the next vertex / and dequue accn to confition 
            //check point xvi in notebook 
                continue;
            
            //otherwise 
            //mark the currentvertex as visited in the small array we made check the notebook 
            visited[currentVertex] = true;
            //add this vertex in the answer array
            answer.add(currentVertex);
            //and then we need to explore the neighbours 
            for(int currentNeigh: adj.get(currentVertex)){
                queue.add(currentNeigh);
            }
        }
    return answer;
    }
}