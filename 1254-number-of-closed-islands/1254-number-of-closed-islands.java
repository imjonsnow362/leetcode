class Solution {
    public int closedIsland(int[][] grid) {
        //first lets find out the number of rows and number of columns 
        int m = grid.length;
        int n = grid[0].length;
        int answer = 0;
        //I want to completely sink the borders of the grid because there cannot be a closed island on the border 
        for(int currentCol = 0; currentCol < n; currentCol++){
            //this means we have an open island here (0 is an island)
            //for 0th row  
            if(grid[0][currentCol] == 0)
                dfs(grid, 0, currentCol, m, n);
            // for last row 
            if(grid[m-1][currentCol] == 0)
                dfs(grid, m-1, currentCol, m, n);  
        }
        
        for(int currentRow = 0; currentRow < m; currentRow++){
            //iterating over 0th column -currentRow and 0th column
            if(grid[currentRow][0] == 0)
                dfs(grid, currentRow, 0, m, n);
            //for last column 
            if(grid[currentRow][n-1] == 0)
                dfs(grid, currentRow, n-1, m, n);
        }
        //Once this is done I just need to iterate over your given grid 
        for(int currentRow = 0; currentRow < m; currentRow++)
            for(int currentCol = 0; currentCol < n; currentCol++){
                //if this below condition satisfies that means it is a closed island and we need to increment count by 1 
                if(grid[currentRow][currentCol] == 0){
                    dfs(grid, currentRow, currentCol, m, n);
                    answer += 1;
                }
            }
        return answer;
    }
    
    private void dfs(int[][] grid, int currentRow, int currentCol, int m, int n){
        
        if(currentRow < 0 || currentRow >= m || currentCol < 0 || currentCol >= n || grid[currentRow][currentCol] == 1)
            return;
        
        grid[currentRow][currentCol] = 1;
        
        dfs(grid, currentRow-1, currentCol, m, n);
        dfs(grid, currentRow+1, currentCol, m, n);
        dfs(grid, currentRow, currentCol-1, m, n);
        dfs(grid, currentRow, currentCol+1, m, n);
        return;
    }
}