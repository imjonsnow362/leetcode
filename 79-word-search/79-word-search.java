class Solution {
    public boolean exist(char[][] board, String word) {
        //First we will find the size 
        int m = board.length;
        int n = board[0].length;
        
        for(int currentRow=0; currentRow < m; currentRow++)
            for(int currentCol=0; currentCol < n; currentCol++){
                
                //the cases in which we are going to run a DFS 
                //if the first character matches i.e. starting point and char at index 0 in string matches 
                //findWord function is the DFS function
                //the value present in the 0th index should be equal to the cell of the board 
                if(board[currentRow][currentCol] == word.charAt(0) && findWord(board, currentRow, currentCol, 0, word, m, n))
                    //If this function is returning true that means I have found the complete string
                    return true;
        }
        return false;
    }
    private boolean findWord(char[][] board, int currentRow, int currentCol, int currentIndex, String word, int m, int n){
        //in the dfs if the currentIndex is equal or more than the word length that means we have got the answer and we can return true 
        //if you check dfs tree the currentIndex is increasing only when we get the right answer it will backtrack if the string is wrong so this is correct
        if(currentIndex >= word.length())
            return true;
        if(currentRow < 0 || currentRow >= m || currentCol < 0 || currentCol >= n || board[currentRow][currentCol] != word.charAt(currentIndex))
            return false;
        //I have got the value I was looking for So I will change the value to dot or cross it to keep track that I have visited the cell
        //But there is a possibility that I have to change it back if the dfs is invalid **[backtracking]**
        //I will store it 
        Character temp = board[currentRow][currentCol];
        board[currentRow][currentCol] = '.';
        //up
        boolean found = findWord(board, currentRow-1, currentCol, currentIndex+1, word, m, n);
        //down
        found = found || findWord(board, currentRow+1, currentCol, currentIndex+1, word, m, n);
        //left
        found = found || findWord(board, currentRow, currentCol-1, currentIndex+1, word, m, n);
        //right
        found = found || findWord(board, currentRow, currentCol+1, currentIndex+1, word, m, n);
        
        //when we have explored all the possibilities undo the change and bring it back to the same character which was in that cell in the dot   
        board[currentRow][currentCol] = temp;
        return found;
    }
}