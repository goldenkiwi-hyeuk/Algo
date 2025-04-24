import java.util.*;

class Solution {
    
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int[][] dp = new int[onboard.length][51];
        int INF = 987654321;
        for(int i = 0; i<onboard.length ; ++i ){
            Arrays.fill(dp[i], INF);
        }
        dp[0][temperature+10] = 0;
        for(int i = 0; i<onboard.length-1 ; ++i){
            for(int j = 0; j<51; ++j){
                if(dp[i][j] != INF){
                    if(j == temperature+10){
                        dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]);
                        if(onboard[i+1] == 1){
                            if((j<t1+10)||(j>t2+10)){
                                dp[i+1][j] = INF;
                            }
                        }
                        if(j != 50) {
                            dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j]+a);
                            if(onboard[i+1] == 1){
                                if((j+1<t1+10)||(j+1>t2+10)){
                                    dp[i+1][j+1] = INF;
                                }
                            }
                        }
                        if(j != 0){
                            dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j]+a);
                            if(onboard[i+1] == 1){
                                if((j-1<t1+10)||(j-1>t2+10)){
                                    dp[i+1][j-1] = INF;
                                }
                            }
                        }
                    } else if (j > temperature+10){
                        dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+b);
                        if(onboard[i+1] == 1){
                            if((j<t1+10)||(j>t2+10)){
                                dp[i+1][j] = INF;
                            }
                        }
                        if(j != 50) {
                            dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j]+a);
                            if(onboard[i+1] == 1){
                                if((j+1<t1+10)||(j+1>t2+10)){
                                    dp[i+1][j+1] = INF;
                                }
                            }
                        }
                        if(j != 0){
                            dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j]);
                            if(onboard[i+1] == 1){
                                if((j-1<t1+10)||(j-1>t2+10)){
                                    dp[i+1][j-1] = INF;
                                }
                            }
                        }    
                    } else {
                        dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+b);
                        if(onboard[i+1] == 1){
                            if((j<t1+10)||(j>t2+10)){
                                dp[i+1][j] = INF;
                            }
                        }
                        if(j != 50) {
                            dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j]);
                            if(onboard[i+1] == 1){
                                if((j+1<t1+10)||(j+1>t2+10)){
                                    dp[i+1][j+1] = INF;
                                }
                            }
                        }
                        if(j != 0){
                            dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j]+a);
                            if(onboard[i+1] == 1){
                                if((j-1<t1+10)||(j-1>t2+10)){
                                    dp[i+1][j-1] = INF;
                                }
                            }
                        } 
                    }
                }
            }
        }
        int ans = 987654321;
        for(int i = 0; i<51 ; ++i){
            ans = Math.min(ans,dp[onboard.length-1][i]);
        }
        return ans;
    }
}