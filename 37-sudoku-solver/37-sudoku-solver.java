class Solution {
    public void solveSudoku(char[][] board) {
        //create a recursive function -- we will pass the board , currentrow, currentcolumn, size of the board
        sudokuSolver(board, 0, 0, board.length);
        //after this particular function we are going to be changing everything in the board
        return;
    }
    //recursive function from line 4,5
    private boolean sudokuSolver(char[][] board, int currentRow, int currentCol, int n){
        //if my current row is equal to n that means the sudoku puzzle is solved
        if(currentRow == n)
           return true;
            //when current row is not equal to n 
            //if my current column is not equal to n-1 that means it is not the last column 
            //in that case the next will be current row only 
            int nextRowIndex = -1;
            int nextColIndex = -1;
            
            if(currentCol != n-1){
                nextRowIndex = currentRow;
                nextColIndex = currentCol+1;
            }else{
                //if i am present in the last column
                nextRowIndex = currentRow+1;
                nextColIndex = 0;
            }
            //we are going to check whether we have an empty cell or not 
            //if it is not equal to dot in that case we know that the cell is already filled  
            if(board[currentRow][currentCol] != '.')
                //if the cell is already filled we need to make a call to the function
                //by putting nextRowIndex and nextRowCol we can move to the next cell
                return sudokuSolver(board, nextRowIndex, nextColIndex, n);
            //if it is not filled we are going to have all the 9 possibilities -- 9 for size of grid --- to explore all the 9 possibilities we will use for loop  
            for(char currentVal= '1'; currentVal<='9'; currentVal++){
                //I will fill the cell with currentVal
                //I need to check whether it is going to be a valid move or not
                //It will check whether I can fill currentRow and currentCol with the currentVal or not it will start by putting 1 in currentRow,currentCol and it will change to 2,3, upto 9 till we get a valid cell 
                if(isValid(board, currentRow, currentCol, currentVal, n)){
                    //if the function is giving true I will make a call to the next cell
                    //we will update the value of board with currentVal 
                    //we will change the value to string 
                    board[currentRow][currentCol] = currentVal; 
                    //if this function call below is returning true we dont need to do anything
                    if(sudokuSolver(board, nextRowIndex, nextColIndex, n))
                        return true;
                    //if the above function is returning false we need to undo the change because we havent got the answer we were looking for 
                    //backtrack 
                    board[currentRow][currentCol] = '.';
                    //we will update it with a dot and explore the second possibility
                }
            }
            //if we are not able to fill up our cell with any value then we will return false 
            return false;
            //isValid function is still left 
    }
        //isvalid function 
        private boolean isValid(char[][] board, int currentRow, int currentCol, char currentVal, int n){
            //I want to check whether row is valid or not 
            //since I want to check in the entire row 
            return  isrowValid(board, currentRow, n, currentVal) && 
                    iscolValid(board, currentCol, currentVal, n) &&
                    isSubGridValid(board, currentRow, currentCol, currentVal, n);
            //if all these functions are going to return us true then we can fill the cell with that particular current value          
        }
        
        private boolean isrowValid(char[][] board, int currentRow, int n, char currentVal){
            
            for(int currentCol=0; currentCol < n; currentCol++){
                
                if(board[currentRow][currentCol]  == currentVal)
                    //because we are already having a value present in the same grid  
                    return false;
            }
            //if in the complete row I am not finding the value I will simply return true
            return true;
        }
        
        private boolean iscolValid(char[][] board, int currentCol, char currentVal, int n){
            
            for(int currentRow=0; currentRow < n; currentRow++){
                
                if(board[currentRow][currentCol]  == currentVal)
                    //because we are already having a value present in the same grid  
                    return false;
            }
            //if in the complete row I am not finding the value I will simply return true
            return true;
        }
       
        private boolean isSubGridValid(char[][] board, int currentRow, int currentCol, char currentVal, int n){
            int startRowIndex = 3 * (currentRow / 3);
            int startColIndex = 3 * (currentCol / 3);
            
            for(int i = startRowIndex; i <= startRowIndex+2; i++)
                for(int j = startColIndex; j <= startColIndex+2; j++){
                    //check all the cells in the board
                    if(board[i][j] == currentVal)
                        return false;
                }
            //after iterating over the entire subgrid we are not finding the value return ture that we can fill thsi cell 
            return true;
        }
}