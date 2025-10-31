import java.util.*;

class Solution{
    public int solution(String s){
        int answer = 1;
        int size = s.length();
        boolean[][] dp = new boolean[size][size];
        for(int i = 0; i<size; ++i){
            dp[i][i] = true;
        }
        
        for(int i = 0; i<size-1; ++i){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                answer = 2;
            }
        }
        
        for(int len = 2; len <size ; ++len){
            for(int st = 0 ; st< size-len; ++st){
                if(s.charAt(st) == s.charAt(st+len) && dp[st+1][st+len-1]){
                    dp[st][st+len] = true;
                    answer = Math.max(len+1, answer);
                }
            }
        }


        return answer;
    }
}