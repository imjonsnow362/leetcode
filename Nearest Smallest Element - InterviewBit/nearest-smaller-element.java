public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        //I want to return the answer in form of ArrayList so 
        ArrayList<Integer> answer = new ArrayList<>();
        //Initialise stack 
        Stack<Integer> stack = new Stack<>();
        //Iterate through the list 
        for(int currentVal:A){
            
            while(!stack.isEmpty() && stack.peek() >= currentVal)
                stack.pop();
                
            //there are two cases if the stack is empty we will put -1 otherwise we will put that element on top of the stack 
            answer.add(stack.isEmpty() ? -1 : stack.peek());
            stack.push(currentVal);
        }
        
        return answer;
        
    }
}
