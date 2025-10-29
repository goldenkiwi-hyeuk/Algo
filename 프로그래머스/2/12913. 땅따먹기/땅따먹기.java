import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];
        for(int i = 0; i<4; ++i){
            dp[0][i] = land[0][i];
        }
        for(int i = 1; i<land.length; ++i){
            for(int j = 0; j<4; ++j){
                int num = Math.max(Math.max(dp[i-1][(j+1)%4],dp[i-1][(j+2)%4]),dp[i-1][(j+3)%4]);
                dp[i][j] = num + land[i][j];
            }
        }

        for(int i = 0; i<4; ++i){
            answer = Math.max(answer, dp[land.length-1][i]);
        }
        return answer;
    }
}