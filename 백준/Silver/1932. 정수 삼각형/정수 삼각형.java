import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] triangle = new int[N+1][];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			triangle[i] = new int[i];
			for (int j = 0; j < i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[N+1][];
		dp[1] = new int[1];
		dp[1][0] = triangle[1][0];
		for (int i = 2; i <= N; i++) {
			dp[i] = new int[i];
			for (int j = 0; j < i; j++) {
				if(j==0){
					dp[i][j] = dp[i-1][j]+triangle[i][j];
				} else if(j==i-1){
					dp[i][j] = dp[i-1][j-1]+triangle[i][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+triangle[i][j];
				}
			}
		}
		Arrays.sort(dp[N]);
		System.out.println(dp[N][N-1]);
	}
}
