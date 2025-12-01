import java.util.*;

class Solution {
    // 순위 배열
    static int[] rank;
    // 관계 배열
    static int[][] league;
    static final int INF = 987654321;
    public static int solution(int n, int[][] results) {
        int answer = 0;
        rank = new int[n+1];
        league = new int[n+1][n+1];
        for(int i  = 0; i<n+1; ++i){
            Arrays.fill(league[i],INF);
        }
        
        for(int[] result : results){
            int win = result[0];
            int lose = result[1];
            league[win][lose] = 1;
            league[lose][win] = 0;
        }

        // 플로이드 와샬 알고리즘을 통해서 관계 정리하기
        for(int k = 1; k<n+1; ++k){
            for(int i = 1; i<n+1; ++i){
                for(int j = 1; j<n+1; ++j){
                    // i>k이고 k>j이면 i>j
                    if(league[i][k]==1 && league[k][j] == 1){
                        league[i][j] = 1;
                    }
                    // i<k이고 k<j이면 i<j
                    if(league[i][k]==0 && league[k][j] == 0){
                        league[i][j] = 0;
                    }
                }
            }    
        }

        // 모든 관계가 드러난 행은 순위 확정
        for(int i = 1; i<n+1;++i){
            boolean flag = true;
            for(int j = 1; j<n+1;++j){
                if(league[i][j] == INF && i!=j){
                    flag = false;
                    break;
                }
            }
            if(flag){
                ++answer;
            }
        }
        return answer;
    }
}