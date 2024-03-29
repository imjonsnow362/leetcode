class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       //we will need to find the number of rows and number of cols 
        //to find no of rows
        int m = matrix.length;
        //to find no of cols
        int n = matrix[0].length;
        
        int start = 0;
        int end = m*n-1;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            int rowIndex = mid / n;
            int colIndex = mid % n;
            
            if(matrix[rowIndex][colIndex] == target)
                return true;
            
            if(matrix[rowIndex][colIndex] > target)
                end = mid - 1;
            
            else 
                start = mid + 1;
        }
        return false;
        
    }
}