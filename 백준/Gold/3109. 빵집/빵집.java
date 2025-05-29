import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R, C, line;
    static int[][] map;
    static boolean[][] visited;
    static int[][] delta = {{-1,0,1},{1,1,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                if (str.charAt(j) == '.') {
                    map[i][j] = 0;
                } else if (str.charAt(j) == 'x') {
                    map[i][j] = -1;
                }
            }
        }

        line = 1;
        for (int i = 0; i < R; i++) {
            boolean isok = checkMap(i,0,line);
            if (isok) {
                ++line;
            }
        }
        
        System.out.println(line-1);
    }

    private static boolean checkMap(int row, int col, int line) {
        visited[row][col] = true;
        map[row][col] = line;
        if (col == C-1){
            return true;
        }

        for (int dir = 0; dir < 3; dir++) {
            int nr = row + delta[0][dir];
            int nc = col + delta[1][dir];
            if (inRange(nr,nc)){
                boolean isok = checkMap(nr,nc,line);
                if (isok) {
                    return true;
                }
            }
        }
        map[row][col] = 0;
        return false;
    }

    private static boolean inRange(int nr, int nc) {
        if((nr >= 0) && (nr < R) && (nc >= 0) && (nc < C) && (map[nr][nc] == 0)&& (visited[nr][nc] == false)) {
            return true;
        }
        return false;
    }
}
