import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] number = {{1, 2}, {2, 5}, {3, 5}, {4, 4}, {5, 5}, {6, 6}, {7, 3}, {8, 7}, {9, 6}, {0, 6}};
        long[] dp = new long[101];
        int [] arr= {1,7,4,2,0,8};
        Arrays.fill(dp,Long.MAX_VALUE);
        dp[2]=1;
        dp[3]=7;
        dp[4]=4;
        dp[5]=2;
        dp[6]=6;
        dp[7]=8;
        dp[8]=10;
        for(int i=9; i<=100; i++){
            for(int j=2; j<=7; j++){
                String temp = String.valueOf(dp[i-j])+String.valueOf(arr[j-2]);
                dp[i] = Math.min(Long.parseLong(temp),dp[i]);
            }
        }

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append(" ");
            if (n % 2 == 0) {
                for (int i = 0; i < n / 2; ++i) {
                    sb.append("1");
                }
            } else {
                sb.append("7");
                for (int i = 0; i < n / 2 - 1; ++i) {
                    sb.append("1");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
