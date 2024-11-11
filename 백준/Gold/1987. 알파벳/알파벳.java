import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static Set<Character> set;
    static int[][] delta = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    static int max, R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        set = new HashSet<>();
        set.add(map[0][0]);
        max = 0;
        go(0, 0);
        System.out.println(max);
    }

    private static void go(int row, int col) {
        if (set.size() > max) {
            max = set.size();
        }

        for (int dir = 0; dir < 4; dir++) {
            int nr = row + delta[0][dir];
            int nc = col + delta[1][dir];
            if ((nr >= 0) && (nr < R) && (nc >= 0) && (nc < C) && (!set.contains(map[nr][nc]))) {
                set.add(map[nr][nc]);
                go(nr, nc);
                set.remove(map[nr][nc]);
            }
        }
    }
}
