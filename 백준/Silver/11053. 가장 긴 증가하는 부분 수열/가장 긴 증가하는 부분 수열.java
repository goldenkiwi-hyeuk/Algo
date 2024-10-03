import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]&&dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
