class Solution {
    public boolean canArrange(int[] arr, int k) {
        //intialise a hashmap/array here 
        //keep the size as k it will make k blocks startting from 0th index to              k-1
        int[] memo = new int[k];
        //just need to iterate over this array 
        for(int currentval: arr){
            //now I will find the remainder here 
            // to keep the remainder positiive I will keep plus k 
            int currentRemainder = ((currentval % k) +k) %k;
            //increase frequency by 1 in array
            memo[currentRemainder] += 1;
        }
        //iterate over memo array
        //why k/2 because lets say if we make a pair of (1,4) so do we need to check pair of (4,1)
        //so if we do k/2 half of the path already gets checked 
        for(int i=0; i<= k/2; i++){
            //if value of  i is 0 the remainder should be even the frequency should be even  
            //memo[i]%2 is not equal to 0 that means it is odd 
            if( i == 0){
                //if integers having 0 remainders are odd in number that means they cannot be mapped together 
                if(memo[i] % 2 != 0)
                    return false;   
            }
            else{
               // i will be mapped with k-i
                int y = k - i;
                if(memo[i] != memo[y])
                    return false; 
            }
        }
         //finally after this for loop we know that we are not failing any condition 
                //we know that we are able to map everything 
                //so just return true 
                return true;
    }
}