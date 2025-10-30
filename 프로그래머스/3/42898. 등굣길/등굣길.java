import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
            
        Set<Integer> set = new HashSet<>();
        for(int[] puddle : puddles){
            set.add(puddle[1]*1000+puddle[0]);
        }
        
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;
        
        for(int i = 1 ; i<=n ; ++i){
            for(int j = 1 ; j<=m ; ++j){
                if(i == 1 && j == 1) continue;
                if(set.contains(i*1000+j)) continue;
                dp[i][j] = ((dp[i-1][j]%mod)+(dp[i][j-1]%mod))%mod;
            }
        }


        return dp[n][m];
    }
}