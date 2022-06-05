//Each number in candidates is supposed to be used only once in the the combination
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); //Arrays sorted to avoid duplicates 
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum(candidates, 0, target, new ArrayList<Integer>(), ans);
        return ans;
    }
    public void combinationSum(int[] a, int ci, int s,List<Integer> subset, List
<List<Integer>> ans){
        if(s==0)
        {
            ans.add(new ArrayList(subset));
            return;
        }
        if(ci>=a.length)
            return;
        if(a[ci]<=s)
        {
            subset.add(a[ci]);
            combinationSum(a,ci+1,s-a[ci],subset,ans); //Path if the element choosen for subset 
            subset.remove(subset.size()-1);   //Backtracking
        }
        
        while(ci<a.length-1&&a[ci]==a[ci+1]) // Skipping the duplicate elements
            ci++;
        combinationSum(a,ci+1,s,subset,ans); //path if the element is not choosen
        return;
    }
}