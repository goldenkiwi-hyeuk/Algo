import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for(int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; ++i) {
			Queue<Integer> que = new ArrayDeque<>();
			for(int j = 0; j<N;++j) {
				if(map[i][j]==1) {
					que.add(j);
				}
			}
			while(!que.isEmpty()) {
				int num = que.poll();
				int[] numbers = map[num];
				for(int j = 0; j<N;++j) {
					if(map[i][j]!=1&&numbers[j]==1) {
						que.add(j);
						map[i][j]=1;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j< N; ++j) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
