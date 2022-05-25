
#define ll long long 
ll mod = 1e9+7,n;
string s;
ll dp[100005][5];

ll rec(ll i,ll dif){
    if(i==n) return 1;
    if(dp[i][dif]!=-1) return dp[i][dif];
    int mx=3;
    if(s[i]-'0'==7 or s[i]-'0'==9) mx=4;
    int ans=rec(i+1,1);
    if(i and dif+1<=mx and s[i]==s[i-1]) ans=(ans+rec(i+1,dif+1))%mod;
    return dp[i][dif]=ans;
}

class Solution {
public:
    int countTexts(string pressedKeys) {
        n=pressedKeys.size();
        s=pressedKeys;
        for(int i=0;i<n;i++) for(int j=0;j<5;j++) dp[i][j]=-1;
        return rec(0,0);
    }
};