class Solution {
    public int numIslands(char[][] grid) {
        //Initialise answer variable to store total connected components 
        int answer = 0;
        //to find number of rows
        int m = grid.length;
        int n = grid[0].length;
        
        //Run a DFS for all the vertices
        for(int currentRow=0; currentRow < m; currentRow++)
            for(int currentCol=0; currentCol < n; currentCol++){
                //if the value is 1 it is an island
                //I will run a DFS only when the value is 1 
                if(grid[currentRow][currentCol] == '1'){
                    sinkIsland(grid, currentRow, currentCol, m, n);
                    //When we know that we are running a DFS here we have got an island so we will increment asnwer by 1 
                    answer+=1;
                }
            }
            return answer;
        }
        
        private void sinkIsland(char[][] grid, int currentRow, int currentCol, int m, int n){
            
            if(currentRow < 0 || currentRow >= m || currentCol < 0 || currentCol >= n || grid[currentRow][currentCol] == '0')
                return;
            
            //if this is not the case mark the current Cell as 0 basically marking it as visited 
            grid[currentRow][currentCol] = '0';
            //Setting the rules for direction up down right left 
            sinkIsland(grid, currentRow-1, currentCol, m, n);
            sinkIsland(grid, currentRow+1, currentCol, m, n);
            sinkIsland(grid, currentRow, currentCol-1, m, n);
            sinkIsland(grid, currentRow, currentCol+1, m, n);
            return;
    }
}