import java.util.*;
import java.io.*;

class Main {
    static int N,M,K;
    static int[] candy, parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        candy = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N;++i){
            candy[i] = Integer.parseInt(st.nextToken());
        }
        
        parent = new int[N+1];
        for(int i = 1; i<=N;++i){
            parent[i] = i;
        }
        
        for(int i = 1; i<=M;++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            unionParent(a,b);
        }
        
        int[][] candyList = new int[N+1][2];
        for(int i = 1; i<=N;++i){
            int parentNum = findParent(i);
            ++candyList[parentNum][0];
            candyList[parentNum][1] += candy[i];
        }
        Arrays.sort(candyList, (o1,o2)->{
            if(o1[0]== o2[0]){
                return o2[1]-o1[1];
            }else {
                return o1[0]-o2[0];
            }
        });
        
        // for(int i = 0; i<=N; ++i){
        //     System.out.println(Arrays.toString(candyList[i]));
        // }
        
        int[][] dp = new int [N+1][K];
        for(int i = 1; i<=N; ++i){
            if(candyList[i][0] == 0){
                continue;
            }
            for(int j = 1; j<K; ++j){
                if(candyList[i][0]<=j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-candyList[i][0]]+candyList[i][1]);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        // for(int i = 0; i<=N; ++i){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        
        System.out.println(dp[N][K-1]);
    }
    
    private static int findParent(int num){
        if(parent[num]==num) return num;
        
        return parent[num] = findParent(parent[num]);
    }
    
    private static void unionParent(int num1, int num2){
        int num1P = findParent(num1);
        int num2P = findParent(num2);
        if(num1P != num2P){
            parent[Math.max(num1P,num2P)] = Math.min(num1P,num2P);
        }
    }
}