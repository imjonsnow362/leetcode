class Solution {
    public int beautySum(String s) {
    int sum=0;
    for(int i=0;i<s.length();i++)
    {
        int freq[]=new  int[26];
        for(int j=i;j<s.length();j++)
        {
            char temp=s.charAt(j);
            freq[temp-'a']++;
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            for(int val:freq)
            {
                if(val!=0)
                {
                    min=Integer.min(min,val);
                    max=Integer.max(max,val);
                }
            }
            
            if(max-min!=0)
                sum+=max-min;
        }
    }
    return sum;
}
}