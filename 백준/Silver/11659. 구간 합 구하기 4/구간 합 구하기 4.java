import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str =  br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		str = br.readLine();
		st = new StringTokenizer(str);
		for(int i=1; i<=N;++i) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for(int m=0; m<M;++m) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(arr[j]-arr[i-1]).append("\n");
		}
		System.out.println(sb);
	}
}
