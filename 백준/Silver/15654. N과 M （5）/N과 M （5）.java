import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] arr;
	static int[] arr2;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		arr2 = new int[M];
		str = br.readLine();
		st = new StringTokenizer(str);
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		go(0);
		System.out.println(sb.toString());
	}

	public static void go(int cnt) {
		if(cnt==M){
			for(int i = 0; i < M; i++){
				sb.append(arr2[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i = 0 ; i<N;++i){
			if(!visited[i]){
				visited[i] = true;
				arr2[cnt] = arr[i];
				go(cnt+1);
				visited[i] = false;
			}
		}
	}
}
