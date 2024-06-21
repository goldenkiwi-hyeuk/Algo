import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[][] delta = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int r = 0; r < N; ++r) {
			str = br.readLine();
			for (int c = 0; c < M; ++c) {
				map[r][c] = str.charAt(c) - 48;
			}
		}
		Queue<int[]> que = new ArrayDeque<>();
		int[] start = { 0, 0, 1 };
		visit[start[0]][start[1]] = true;
		que.add(start);
		while (true) {
			int[] arr = que.poll();
			
			if ((arr[0] == N - 1) && (arr[1] == M - 1)) {
				System.out.println(arr[2]);
				break;
			}
			for (int dir = 0; dir < 4; ++dir) {
				int nr = arr[0] + delta[0][dir];
				int nc = arr[1] + delta[1][dir];
				if ((nr >= 0) && (nr < N) && (nc >= 0) && (nc < M) && (map[nr][nc] == 1) && (visit[nr][nc] == false)) {
					int[] goal = { nr, nc, arr[2] + 1 };
					visit[nr][nc] = true;
					que.add(goal);
				}
			}
		}
	}
}