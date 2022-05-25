class Solution{
    public int numRabbits(int[] answers){
        double answer = 0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        for(int currentReportee: answers){
            if(memo.containsKey(currentReportee))
                memo.put(currentReportee, memo.get(currentReportee)+1);
            else
               memo.put(currentReportee, 1);
        }
        for(Integer currentKey: memo.keySet()){
            double groupSize = currentKey+1;
            double numGroups = Math.ceil(memo.get(currentKey)/ groupSize);
            answer += (numGroups * groupSize);
        }
        return (int) answer;
    }
}