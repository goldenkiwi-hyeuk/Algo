import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, cnt;
    static int[][] delta = {{0, 1, 1}, {1, 1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        checkmap(0, 1, 0);
        System.out.println(cnt);
    }

    public static void checkmap(int r, int c, int dir) {
        if ((r == N - 1) && (c == N - 1)) {
            ++cnt;
            return;
        }

        for (int i = 0; i < 3; i++) {
            if ((dir == 0) && (i == 2)) continue;
            if ((dir == 2) && (i == 0)) continue;
            int nr = r + delta[0][i];
            int nc = c + delta[1][i];
            if (i == 1) {
                if ((nr < N) && (nr >= 0) && (nc < N) && (nc >= 0) && (map[nr][nc] == 0) && (map[nr][c] == 0) && (map[r][nc] == 0)) {
                    checkmap(nr, nc, i);
                }
            } else {
                if ((nr < N) && (nr >= 0) && (nc < N) && (nc >= 0) && (map[nr][nc] == 0)) {
                    checkmap(nr, nc, i);
                }
            }
        }
    }
}
