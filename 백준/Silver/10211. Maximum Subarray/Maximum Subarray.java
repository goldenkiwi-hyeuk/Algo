import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc<T ; ++tc){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N ; ++i){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[N];
            dp[0] = arr[0];
            int max = dp[0];
            for(int i = 1; i<N ; ++i){
                dp[i] = Math.max(dp[i-1],0)+arr[i];
                max = Math.max(dp[i], max);
            }
            
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}