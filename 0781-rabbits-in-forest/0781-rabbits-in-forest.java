class Solution{
    public int numRabbits(int[] answers){
        //CHECK PAGE 231
        double answer = 0;
        //Count out all rabbits firstly
        HashMap<Integer, Integer> memo = new HashMap<>();
        //iterate over answers array
        for(int currentReportingRabbit: answers){
            //if reporting rabbit is present in the map we need to increase frequency by 1  
            if(memo.containsKey(currentReportingRabbit))
                memo.put(currentReportingRabbit, memo.get(currentReportingRabbit)+1);
            else
                //if reporting rabbit is not present we will create a new entry 
               memo.put(currentReportingRabbit, 1);
        }
        //Iterate over HashMap 
        //https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
        for(Integer currentKey: memo.keySet()){
            //Size of the group will be currentKey + 1
            double groupSize = currentKey+1;
            //Now we need to find number of groups //Check Pg 233 and 234 for logic
            double numGroups = Math.ceil(memo.get(currentKey)/ groupSize);
            //Once we have numberGroups and groupSize we have to add them in answer
            answer += (numGroups * groupSize);
        }
        //(int) means typecasting 
        return (int) answer;
    }
}