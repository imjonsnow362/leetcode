class Solution {
    public String frequencySort(String s) {
        //Check Page 177
        //Optimal Priority Queue solution - 
        //Count each characters and how many time it occurs using Hashmap
        HashMap<Character, Integer> map = new HashMap<>();
        //Count every character
        for(char c: s.toCharArray()){
            //Using map.put its going to see the first time we see a character c and check using getOrDefault whether it is present in the map or not 
            //if the character has come first time then it will give us 0 and then add 1 to it 
            //if the character is repeating then we will get a value for c in the map so we will return how many times it has occured and add 1 to it.
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        //This is going to hold characters based on their count 
        //The max occuring character will be at the root of the heap 
        //We will pass the constructor a lamda function telling the heap how to compare two items
        //The way to compare them is based on the count of character which is stored in the map 
        PriorityQueue<Character> maxheap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        //Take all the characters from Hashmap and throw them in the heap 
        maxheap.addAll(map.keySet());
        //Removing everything from heap throwing everything in the stringbuilder 
        StringBuilder result = new StringBuilder();
        //Going through everything present in maxheap using while loop 
        while(!maxheap.isEmpty()){
            //get the current char
            char current = maxheap.remove();
            //Add a character to the string builder how many times it occurs 
            //e.g. eert so print e 2 times
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