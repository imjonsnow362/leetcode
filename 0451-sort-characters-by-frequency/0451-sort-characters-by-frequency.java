class Solution {
    public String frequencySort(String s) {
        //Optimal Priority Queue solution 
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        PriorityQueue<Character> maxheap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        maxheap.addAll(map.keySet());
        
        StringBuilder result = new StringBuilder();
        while(!maxheap.isEmpty()){
            char current = maxheap.remove();
            for(int i = 0; i<map.get(current); i++){
                result.append(current);
            }
        }
        return result.toString();
    }
}
        /*
        //MY SOLUTION using Array of 26
        public String frequencySort(String s) {
        //Add base case 
        //Using alphabet I will store the value of count of each character
        int[] char_count = new int[26];
        //Iterate through s and get value of each character
        for(int i=0; i<s.length(); i++){
            char_count[s.charAt(i)-'a']++;
    }
        //Arrange characters with count and print the array in descending order
        for(int count: char_count){
            
        }
}
*/