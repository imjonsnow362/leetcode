class Solution {
    public int maxDepth(String s) {
        //Page 181
        //We will keep one count variable for opening and closing bracket 
        //Depth will store maximum value of open 
        int depth = 0, open = 0;
        for(char c: s.toCharArray()){
            //Increase count of open if we get opening bracket
            if(c == '(')
                open++;
            //Decrease count of open if we get closing bracket
            if(c == ')')
                open--;
            depth = Math.max(depth, open);
        }
        return depth;  
    }
}