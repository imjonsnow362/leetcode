class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {
        //If the value of the cell is 0 then there is nothing to do just return the grid
        //corner case 
        if(grid[sr][sc] == newColor)
            return grid;
    
        //call a dfs function 
        dfs(grid, sr, sc, grid[sr][sc], newColor);
        return grid;
    }
    //grid currentRcurrentC != 1 is same as line 5
    private void dfs(int[][] grid, int currentRow, int currentCol, int color, int newColor){
        if(currentRow < 0 || currentRow >= grid.length || currentCol < 0 || currentCol >= grid[0].length || grid[currentRow][currentCol] != color)
                return;
            
            //if this is not the case mark the current Cell as 0 basically marking it as visited 
            grid[currentRow][currentCol] = newColor;
            //Setting the rules for direction up down right left 
            dfs(grid, currentRow-1, currentCol, color, newColor);
            dfs(grid, currentRow+1, currentCol, color, newColor);
            dfs(grid, currentRow, currentCol-1, color, newColor);
            dfs(grid, currentRow, currentCol+1, color, newColor);
            return;
    }
}