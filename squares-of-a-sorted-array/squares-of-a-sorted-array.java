class Solution {
    public int[] sortedSquares(int[] array) {
        int[] result = new int[array.length];
        int left=0;
        int right=array.length-1;
        for(int i=array.length-1; i>=0; i--){
        if(Math.abs(array[left]) > array[right]){
            result[i] = array[left] * array[left];
            left++;
        } else {
            result[i] = array[right] * array[right];
            right--;
        }
    }
    return result;
}
}