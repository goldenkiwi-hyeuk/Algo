import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];
        int INF = 987654321;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = INF;
            }
        }
        
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dp[start - 1][end - 1] = Math.min(dp[start - 1][end - 1], cost);
        }
        
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    sb.append(0).append(" ");
                } else if (dp[i][j] == INF) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(dp[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
