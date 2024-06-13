import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean[][] visit;
	static int[][] map;
	static int M, N;
	static int[][] delta = {{1,-1,0,0},{0,0,-1,1}}; // 상하좌우
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; ++tc) {
			M = sc.nextInt();
			N = sc.nextInt();
			map = new int[N][M];
			visit = new boolean[N][M];
			int K = sc.nextInt();
			for (int k = 0; k < K; ++k) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = 1;
			}
			sb.append(check()).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int check() {
		int cnt = 0;
		for(int r = 0 ; r<N;++r) {
			for(int c = 0 ; c<M;++c) {
				if(visit[r][c]==false) { // 탐색 안된 위치일때
					if(map[r][c]==1) { // 배추 인가?
						++cnt; // 지렁이 필요
						warm(r,c);
					} else { // 배추 없당
						visit[r][c]=true;
					}
				} 
			}
		}
		return cnt;
	}
	
	public static void warm(int r, int c) {
		visit[r][c] = true;
		for(int dir = 0; dir<4;++dir) {
			int nr = r+delta[0][dir];
			int nc = c+delta[1][dir];
			if((nr>=0)&&(nr<N)&&(nc>=0)&&(nc<M)&&(map[nr][nc]==1)&&(visit[nr][nc]==false)) {
				warm(nr,nc);
			}
		}
	}
}
