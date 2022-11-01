class Solution {
    public List<String> generateParenthesis(int n) {
        //PAGE 204
        ArrayList<String> answer = new ArrayList<>();
        findCombos(0,0,"",n,answer);
        return answer;
    }
    
    private void findCombos(int openCount, int closeCount, String expression, int n, ArrayList<String> answer){
        //Base case
        //Here when n=3 and open count = closeCount could mean 2 = 2 but we need 3 hence we put && case for openCount == n
        if(openCount == closeCount && openCount == n){
            answer.add(expression);
            return;
        }
        
        if(openCount < n){
            findCombos(openCount+1, closeCount,expression + "(", n, answer);
        }
        
        if(openCount > closeCount){
            findCombos(openCount, closeCount + 1,expression + ")", n, answer);
        }
        return;
    }
}