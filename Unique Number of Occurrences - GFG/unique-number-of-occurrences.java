//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            boolean res = obj.isFrequencyUnique(n, arr);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static boolean isFrequencyUnique(int n, int[] arr) {
        // code here
        //ArrayList<Integer> newList = new ArrayList<Integer>();
        /*
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]==arr[j]){
                    if(newList.contains(arr[i])){
                        return false;
                    }else{
                        newList.add(arr[i]);
                    }
                }
            }
        }
        */
        /*
        for(int a1: arr){
            newList.add(a1);
        }
        for(int i=0; i<newList.size(); i++){
            if (newList.contains(newList.get(i))){
                return true;
            }
        }
        return false;
        */
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
    for(int i = 0; i < n; i++){
        if(freqMap.containsKey(arr[i])){
            freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
        } else {
            freqMap.put(arr[i], 1);
        }
    }
    HashSet<Integer> freqSet = new HashSet<Integer>(freqMap.values());
    return freqSet.size() == freqMap.size();
    }
}
        
