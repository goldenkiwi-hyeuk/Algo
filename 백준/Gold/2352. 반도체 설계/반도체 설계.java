import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N;++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N+1];
        
        for(int i = 1; i<=N;++i){
            for(int j = arr[i]; j<=N;++j){
                if(j == arr[i]){
                    dp[j] = dp[j-1]+1;
                } else {
                    dp[j] = Math.max(dp[j-1], dp[j]);
                }
            }
        }
        System.out.println(dp[N]);
    }
}