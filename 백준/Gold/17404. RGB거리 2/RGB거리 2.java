import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            StringTokenizer st =  new StringTokenizer(str);
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N][3];
        int ans = 987654321;
        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp[0], 987654321);
            dp[0][i] = map[0][i];
            for (int j = 1; j <N; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[j][k] = Math.min(dp[j-1][(k+1)%3], dp[j-1][(k+2)%3])+map[j][k];
                }
            }
            if ( Math.min(dp[N-1][(i+1)%3],dp[N-1][(i+2)%3]) < ans){
                ans =  Math.min(dp[N-1][(i+1)%3],dp[N-1][(i+2)%3]);
            }
        }
        System.out.println(ans);
    }
}
