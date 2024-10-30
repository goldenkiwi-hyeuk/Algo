import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            for (int k = 0; k < 2; k++) {
                String str = br.readLine();
                StringTokenizer st = new StringTokenizer(str);
                for (int l = 0; l < n; l++) {
                    arr[k][l] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[2][n];
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            if(n>1){
                dp[0][1] = dp[1][0] + arr[0][1];
                dp[1][1] = dp[0][0] + arr[1][1];
                for (int l = 2; l < n; l++) {
                    dp[0][l] = Math.max(dp[1][l - 2] + arr[0][l], dp[1][l - 1] + arr[0][l]);
                    dp[1][l] = Math.max(dp[0][l - 2] + arr[1][l], dp[0][l - 1] + arr[1][l]);
                }
            }
            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
        }
        System.out.println(sb);
    }
}
