import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s - 1][e - 1]).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void solve() {
        dp = new int[N][N];
        for (int len = 0; len < N; len++) {
            for (int i = 0; i < N - len; i++) {
                if (len == 0) {
                    dp[i][i + len] = 1;
                } else if (len == 1) {
                    if (arr[i] == arr[i + len]) {
                        dp[i][i + len] = 1;
                    }
                } else {
                    if ((arr[i] == arr[i + len]) && (dp[i + 1][i + len - 1] == 1)) {
                        dp[i][i + len] = 1;
                    }
                }
            }
        }
    }
}
