// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public ArrayList<String> findPath(int[][] grid, int n) {
        // Your code here
        //We want to return everything in the form of arraylist of string 
        ArrayList<String> answer = new ArrayList<>();
        //call a recursive function here
        //it will take the grid and also take the starting position (0,0)
        //we want to reach m-1 and n-1 accn to my notebook 
        //this is a square matrix so m and n is n  so we are passing the size of the grid that is n
        //I want to store everything in the form of string then empty string
        //And then answer where we will store this string
        findAllPaths(grid, 0, 0, n, "",  answer);
        //we just need to return answer once it is populated
        return answer;
    }
    
    private void findAllPaths(int[][] grid, int currentRow, int currentCol, int n, String currentPath, ArrayList<String> answer){
        //I need to check whether I am present on a valid cell or not 
        //if coordinates exist or not (e.g. -1,0 in my notebook recursive tree is not valid)
        //if the cell I am moving on has a value 0 then that is a block cell so that is also invalid so 
        //if the cell is -1 i dont need to do anything there also 
        if(currentRow < 0 || currentRow >= n || currentCol < 0 || currentCol >= n || grid[currentRow][currentCol] <= 0)
            return;
        //Now I will check if i am present on the target cell or not 
        if(currentRow == n-1 && currentCol == n-1){
            answer.add(currentPath);
            return;
        }
        //if we are present on a valid cell update the value to -1 like in the notebook recursive tree
        grid[currentRow][currentCol] = -1;
        
        //Make the call in lexical graphical order 
        // down , left , right , up 
        //down move
        //currentRow will increase because we are going down and currentPath we will add D because we going down 
        findAllPaths(grid, currentRow+1, currentCol, n, currentPath + "D", answer);
        
        //left move 
        findAllPaths(grid, currentRow, currentCol-1, n, currentPath + "L", answer);
        
        //right move
        findAllPaths(grid, currentRow, currentCol+1, n, currentPath + "R", answer);
        
        //up move 
        findAllPaths(grid, currentRow-1, currentCol, n, currentPath + "U", answer);
        
        //Once I have explored all the conditions I will undo the change here 
        grid[currentRow][currentCol] = 1;
        return;
        }
}