import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N][3];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N+1][3];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+rgb[i-1][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+rgb[i-1][1];
            dp[i][2] = Math.min(dp[i-1][1],dp[i-1][0])+rgb[i-1][2];
        }
        System.out.println(Math.min(Math.min(dp[N][0],dp[N][1]),dp[N][2]));
    }
}
