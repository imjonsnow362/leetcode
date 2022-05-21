class Solution {
    public void reverseString(char[] s) {
		int left = 0;
        int right = s.length -1;
        while(left<=right){
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
            
            left+=1;
            right-=1;
        }
    }
}
            
            /*Collections.reverse(char.asList(s));
        System.out.println(char.asList(s));*/	
        /*for(int i=s.length-1; i>=0; i--){
				System.out.println(s[i]);*/


 /* class Solution{
	public int reverse(String[] s){
		for(int i=0; i<s.length; i++){
			for(int i=s.length-1; i<=0; i--){
				System.out.println(s[i]);
			}
		}
	}
}
*/