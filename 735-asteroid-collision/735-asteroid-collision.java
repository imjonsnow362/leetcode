class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        //Initialise a stack 
        Stack<Integer> stack = new Stack<>();
        
        //iterate over asteroids array 
        for(int currentAsteroids : asteroids){
            //if cA is moving in right direction (+ve value will be greater 0)
            if(currentAsteroids > 0){
                //if it is +ve I just need to push 
                stack.push(currentAsteroids);
            }
            else{
                //otherwise we are getting an asteroid which is moving in left direction
                //so I want to pop out all the values which have a value lesser than -ve cA
                //check page 97 rule iii),iv)
                //I want to check whether top value present in the stack is greater than 0 or not 
                //because in some cases all values from stack get deleted and we push the -ve value
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(currentAsteroids))
                    stack.pop();
                
                if(stack.isEmpty() || stack.peek() < 0)
                    stack.push(currentAsteroids);
                    
                if(stack.peek() == Math.abs(currentAsteroids))
                    stack.pop();
            }
        }
        int[] result = new int[stack.size()];
        int currentIndex = stack.size()-1;
        
        while(!stack.isEmpty())
            result[currentIndex--] = stack.pop(); 
        
        return result;
    }
}