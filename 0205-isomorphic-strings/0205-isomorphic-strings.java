class Solution {
    public boolean isIsomorphic(String s, String t) {
        //Page 173
        //Base case 
        if(s.length() != t.length()){
            return false;
        } 
        HashMap<Character, Character> map1 = new HashMap<>();
        //I am using two hashmap to check whether there is a character left in string2 to use 
        HashMap<Character, Boolean> map2 = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            //If character is already present in the map then 
            if(map1.containsKey(ch1) == true){
                //If above condition meets then it is mapped with some or the other character in string2
                //Now using if we will check to which character , we need to check whether it is mapped with ch2 or not if not then return false
                if(map1.get(ch1) != ch2){
                    return false;
                }
                //Otherwise if it is not mapped we can map it but for that character has to be unused
                //What this means is that ch1 is not mapped so we we will map it with ch2 but ch2 should be unused we cannot use used character accn to rule 
            }else {
                //So using below line we are checking if ch2 is present in the map if ch2 is present in the map that means it is not unused 
                if(map2.containsKey(ch2) == true){
                    return false;
                }else{
                    ////We will perform mapping ch1 with ch2
                    map1.put(ch1, ch2);
                    //Once map is complete we will specify that ch2 is used using true
                    map2.put(ch2, true);
                }
            }
        }
        return true;
    }
}