#include <iostream>
#include <vector>
using namespace std;
 
int dp[100010][2];
vector<vector<int> > v;
 
void dfs(int node,int pre){
    for(int i=0;i<v[node].size();i++){
        int temp = v[node][i];
        if(temp != pre){
            dfs(temp,node);
            dp[node][0] += max(dp[temp][0],dp[temp][1]);
            dp[node][1] += dp[temp][0];
        }
    }
}
 
int main(){
    int n,a,b;
    cin>>n;
    for(int i=1;i<=n;i++){
        cin>>dp[i][1];
    }
    v.resize(n+1);
    for(int i=1;i<=n-1;i++){
        cin>>a>>b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    dfs(1,0);
    cout<<max(dp[1][0],dp[1][1]);
    return 0;
}