class Solution {
public void merge(int[] nums1, int m, int[] nums2, int n) {
int i=m-1,j=n-1,k=m+n-1;
while(i>=0 || j>=0){
if(i>=0&&j>=0){
if(nums2[j]>nums1[i]){
nums1[k--]=nums2[j--];
}
else{
nums1[k--] =nums1[i--];
}
}
else if(i>=0){
nums1[k--]=nums1[i--];
}
else if(j>=0){
nums1[k--] = nums2[j--];
}
}

}
}
/*class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length=m+n;
        int[] mgArray = new int[length];
        int pos=0;
        for(int element: nums1){  //copying elements of first array into merged array
            mgArray[pos]=element;
            pos++;
        }
        for(int element: nums2){ //copying elements of second array into merged array 
            mgArray[pos]=element;
            pos++;
        }
        //to sort the array in ascending order
        for (int i = 0; i < mgArray.length; i++) {     
            for (int j = i+1; j < mgArray.length; j++) {     
               if(mgArray[i] > mgArray[j]) {    
                   int temp = mgArray[i];    
                   mgArray[i] = mgArray[j];    
                   mgArray[j] = temp;    
               }     
            }     
        }    
    }
}
*/