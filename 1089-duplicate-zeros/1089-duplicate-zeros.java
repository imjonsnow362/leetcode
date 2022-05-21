class Solution {
    public void duplicateZeros(int[] arr) {
      int[] shifted = new int[arr.length];
        for (int i = 0, j = 0; i < arr.length && j < arr.length; i++) {
            if (arr[i] != 0) {
                shifted[j++] = arr[i];
            } else {
                j += 2;
            }
        }
        System.arraycopy(shifted, 0, arr, 0, arr.length);
    }
}