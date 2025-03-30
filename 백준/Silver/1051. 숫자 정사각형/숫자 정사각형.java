import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = (int) str.charAt(j);
            }
        }
        int maxIdx = Math.min(N,M);
        max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < maxIdx; k++) {
                    check(i,j,k);
                }
            }
        }
        System.out.println((max+1)*(max+1));
    }

    private static void check(int i, int j, int k) {
        int r1 = i;
        int c1 = j;
        int r2 = i+k;
        int c2 = j+k;
        if (inRange(r1,c1)&&inRange(r2,c2)) {
            if (map[r1][c1] == map[r2][c2]&& map[r1][c2] == map[r2][c1] && map[r1][c1] == map[r1][c2]) {
                if (max < k) {
                    max = k;
                }
            }
        }
    }

    private static boolean inRange(int row, int col) {
        if ((row>=0)&&(row<N)&&(col>=0)&&(col<M)){
            return true;
        }
        return false;
    }
}
