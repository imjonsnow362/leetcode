class Solution {
    public int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid +1]){
                // you are in the decreasing part of the array
                //this can be the asnwer so start looking at left
                end = mid; // possible answer so not mid -1 
            } else {
                //you are in ascending part of the array 
                start = mid + 1;
            }
        }
        //
        return start;
    }
}