class Solution {
    public int uniquePaths(int m, int n) {
        if(m*n == 0) return 0;
        if(m == 1 || n == 1) return 1;
        
        int[][] board = new int[m][n];
        // fill last row with 1's
        for(int i = 0; i < n; i++){
            board[m-1][i] = 1;
        }
        // fill last col with 1's
        for(int i = 0; i < m; i++)
            board[i][n-1] = 1;
        for(int i = 1; i < m; i++) {
            for(int j = n-1; j > 0; j--) {
				// current cell = cell below + cell to the right
                board[m-i-1][j-1] = board[m-i][j-1] + board[m-i-1][j];
            }
        }
        return board[0][0];
    }
}