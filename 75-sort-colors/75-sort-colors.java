class Solution {
    public void sortColors(int[] nums) {
        
        int zero = 0;
        int one = 0;
        int two = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zero++;
            } else if(nums[i] == 1){
                one++;
            }else{
                two++;
            }
        }
        for(int i = 0; i < zero; i++){
            nums[i] = 0;
        }
        one+=zero;
        for (int i = zero ; i < one; i++){
                
            nums[i]=1;
        }
        two+=one;
        for (int i = one ; i < two ; i++){
                
            nums[i]=2;
        }
    }
}


/*class Solution {
    public void sortColors(int[] a) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int i = 0 ; i < a.length ; i++){
            
            if(a[i]==0){
                zero++;
            }else if(a[i]==1){
                one++;
            }else{
                two++;
            }
        }
        for (int i = 0 ; i < zero ; i++){
                
            a[i]=0;
        }
        one+=zero;
        for (int i = zero ; i < one; i++){
                
            a[i]=1;
        }
        two+=one;
        for (int i = one ; i < two ; i++){
                
            a[i]=2;
        }
    }
}
*/