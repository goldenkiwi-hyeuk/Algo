import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[C+100];
        Arrays.fill(dp,987654321);
        dp[0] = 0;
        for (int i = 0; i < N; ++i) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int cost = Integer.parseInt(st.nextToken());
            int effect = Integer.parseInt(st.nextToken());
            for (int j = effect; j<dp.length;++j){
                dp[j] = Math.min(dp[j], dp[j -effect] + cost);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = C; i<dp.length; ++i) {
            ans = Math.min(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
