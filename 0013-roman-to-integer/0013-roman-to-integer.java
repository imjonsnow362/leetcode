class Solution {
    public int romanToInt(String s) {
        //Page 182
        //Use a Hashmap to map a roman character to a number 
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int result = 0;
        //Iterate through each character
        for(int i=0; i<s.length(); i++){
            //Handle subtractive use case which is when there a character which is higher than it previous character
            if(i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i-1))){
                //So if this if condition is true then the value added at i-1 is a mistake so we need to remove that value from addition and subtract it after adding value at i
                //Why we are subtracting twice is because the value at i-1 is already present in the addition so we subtract it from there and after adding value of i we put i-1 value below that and again subtract
                result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i-1));   
            }else{
            //Additive case just normally add values
            result += map.get(s.charAt(i));
                }
        }
        return result;
    }
}