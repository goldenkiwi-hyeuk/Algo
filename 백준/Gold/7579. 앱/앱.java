import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[N];
        str = br.readLine();
        st = new StringTokenizer(str);
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int[] arr2 = new int[N];
        str = br.readLine();
        st = new StringTokenizer(str);
        for (int i = 0; i < N; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int [N+1][10001];
        for (int i = 1; i <= N; ++i) {
            int effect = arr1[i-1];
            int cost = arr2[i-1];
            for (int j = 0; j <= 10000; ++j) {
                if (j<cost){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost] + effect);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 10000; ++i) {
            if(dp[N][i]>=M){
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
