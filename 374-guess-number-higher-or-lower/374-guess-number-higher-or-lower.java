/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        //Initialise start with first index i.e. 0 
        int start = 0;
        int end = n;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            int temp = guess(mid);
            
            //comparison
            if(temp==0){
                return mid;
            //decide 
            }else if(temp == -1){
                end = mid - 1;
            }
            else{
                start = mid + 1;               
                }
        }
        return -1;
    }
}