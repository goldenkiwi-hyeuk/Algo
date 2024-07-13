import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; ++tc) {
			sb.append("Scenario #").append(tc).append(":").append("\n");
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int[] tri = new int[3];
			tri[0] = Integer.parseInt(st.nextToken());
			tri[1] = Integer.parseInt(st.nextToken());
			tri[2] = Integer.parseInt(st.nextToken());
			Arrays.sort(tri);
			if (tri[2] * tri[2] == tri[0] * tri[0] + tri[1] * tri[1]) {
				sb.append("yes").append("\n").append("\n");
			} else {
				sb.append("no").append("\n").append("\n");
			}
		}
		System.out.println(sb);
	}
}
