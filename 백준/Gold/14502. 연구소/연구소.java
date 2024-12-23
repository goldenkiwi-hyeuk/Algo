import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int min, N, M, wall;
    static boolean[][] visited;
    static int[][] delta = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        map = new int[N][M];
        visited = new boolean[N][M];
        wall = 0;
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    list.add(i * 10 + j);
                } else if (map[i][j] == 1) {
                    ++wall;
                }
            }
        }
        checkmap(3);
        System.out.println(M * N - min - wall - 3);
    }

    private static void checkmap(int wall) {
        if (wall == 0) {
            for (int num : list) {
                virus(num / 10, num % 10);
            }
            int cnt = 0;
            out:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 2) {
                        ++cnt;
                        if (cnt > min) {
                            break out;
                        }
                    }
                }
            }
            if (cnt < min) {
                min = cnt;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 2) {
                        map[i][j] = 0;
                    }
                }
            }
            for (int num : list) {
                map[num / 10][num % 10] = 2;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    if (wall == 3) visited[i][j] = true;
                    checkmap(wall - 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void virus(int r, int c) {
        for (int dir = 0; dir < 4; dir++) {
            int nr = r + delta[0][dir];
            int nc = c + delta[1][dir];
            if ((nr >= 0) && (nr < N) && (nc >= 0) && (nc < M) && (map[nr][nc] == 0)) {
                map[nr][nc] = 2;
                virus(nr, nc);
            }
        }
    }
}
