import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int[] start = new int[3];
		for (int r = 0; r < n; ++r) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int c = 0; c < m; ++c) {
				int data = Integer.parseInt(st.nextToken());
				if (data == 2) {
					map[r][c] = 0;
					start[0] = r;
					start[1] = c;
				} else if (data == 1) {
					map[r][c] = 987654321;
				} else {
					map[r][c] = -1;
				}
			}
		}
		
		int[][] delta = {{-1,1,0,0},{0,0,-1,1}};
		int cnt = 1;
		Queue<int[]> que = new ArrayDeque<>();
		que.add(start);
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i=0; i<size;++i) {
				int[] arr = que.poll();
				for(int dir = 0; dir<4;++dir) {
					int nr = arr[0] + delta[0][dir];
					int nc = arr[1] + delta[1][dir];
					if((nr<n)&&(nr>=0)&&(nc<m)&&(nc>=0)&&(map[nr][nc]!=-1)&&(map[nr][nc]==987654321)) {
						map[nr][nc]= arr[2]+1;
						int[] add = new int[3];
						add[0] = nr;
						add[1] = nc;
						add[2] = map[nr][nc];
						que.add(add);
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < n; ++r) {
			for (int c = 0; c < m; ++c) {
				if(map[r][c]==987654321) {
					map[r][c]=-1;
				} else if(map[r][c]==-1) {
					map[r][c]=0;
				} 
				sb.append(map[r][c]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
