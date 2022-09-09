class Solution {
    public int mySqrt(int x) {
        
        if(x == 0)
            return 0;
        
        int output = -1;
        int start = 1;
        int end = x;
        while(start <= end){
            int mid = start + (end-start)/2;
            //long temp = mid * mid;
            //mid*mid = x -> mid = x/mid;
            
            if(mid == x/mid){
                return mid;
        }else if(mid > x/mid){
            end = mid - 1;
        }else{
                output = mid;
                start = mid + 1;
        }
    }
        return output;
    }
}
