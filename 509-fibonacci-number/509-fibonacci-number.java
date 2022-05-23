class Solution {
    public int fib(int n) {
        return nthFib(n, new HashMap<Integer, Integer>());
    }

    private int nthFib(int n, HashMap<Integer, Integer> memo){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        int currentKey = n;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);

        int a = nthFib(n-1, memo);
        int b = nthFib(n-2, memo);

        memo.put(currentKey, a + b);
        return a+b; 
    }
}
/*
    class Solution {
    public int fib(int n) {
        return nthFib(n);
    }

    private int nthFib(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;


        int a = nthFib(n-1);
        int b = nthFib(n-2);

        return a+b; 
    }
}
*/