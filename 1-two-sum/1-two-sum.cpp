class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int i,sum=0;
        unordered_map<int,int> umap;
        vector<int> ans;
        for(i=0;i<nums.size();i++)
        {
            int key=target-nums[i];
            if(umap.find(key)!=umap.end())
            {
                ans.push_back(i);
                ans.push_back(umap.find(key)->second);
                return ans;
            }
            umap.insert({nums[i],i});
        }  
        return ans;
    }
};