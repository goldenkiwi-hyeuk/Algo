import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[N+1];
		for(int i=1;i<N+1;++i) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		int[][] dp = new int[2][N+1];
		dp[0][1] = stair[1];
		dp[1][1] = stair[1];
		for(int i = 2;  i<N+1;++i) {
			dp[0][i] = dp[1][i-1] + stair[i];
			dp[1][i] = Math.max(dp[0][i-2], dp[1][i-2]) + stair[i];		
		}
		System.out.println(Math.max(dp[0][N], dp[1][N]));
	}
}
