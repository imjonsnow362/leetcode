class Solution {
    public boolean rotateString(String A, String B) {
        //Check page 174
        return(A.length() == B.length() && (A+A).contains(B));
    }
}