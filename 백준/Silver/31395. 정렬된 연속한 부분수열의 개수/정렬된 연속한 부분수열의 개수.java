import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0;) {
            int countNum = 0;
            for (int j = i; j >= 0 ; j--) {
                if (i == j){
                    countNum++;
                    continue;
                }

                if (arr[j] >= arr[j+1]){
                    break;
                } else {
                    countNum++;
                }
            }

            for (int j = 0; j < countNum ; j++) {
                dp[i-j] = countNum-j;
            }
            i -= countNum;
        }

        long cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt += dp[i];
        }
        System.out.println(cnt);
    }
}
