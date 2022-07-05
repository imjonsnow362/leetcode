class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>&grid, int sr, int sc, int newColor) {
        if(grid[sr][sc] == newColor) return grid;
          sinkGraph(grid,sr,sc,grid[sr][sc],grid.size(),grid[0].size(),newColor);
            return grid;
    }
    void sinkGraph(vector<vector<int>>&grid, int curr_row, int curr_col,int color,int m,int n,int newColor)
    {
        if(curr_row<0 || curr_row>=m || curr_col<0 || curr_col>=n || grid[curr_row][curr_col]!=color)
            return;
        grid[curr_row][curr_col] = newColor;
        // up move
        sinkGraph(grid,curr_row-1,curr_col,color,m,n,newColor);
        //right move
        sinkGraph(grid,curr_row,curr_col+1,color,m,n,newColor);
        //down move
        sinkGraph(grid,curr_row+1,curr_col,color,m,n,newColor);
        //left move
        sinkGraph(grid,curr_row,curr_col-1,color,m,n,newColor);
        return;
    }
};