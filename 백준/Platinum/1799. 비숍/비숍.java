import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, black, white;
    static int[][] map;
    static int[][] delta = {{-1, -1,1,1}, {-1, 1,1,-1}}; // 좌상, 우상, 우하, 좌하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        black = 0;
        white = 0;
        checkBishop(0, 0,0 ,2);
        checkBishop(0, 1,1 ,2);
        System.out.println(black+white);
    }

    private static void checkBishop(int r, int c, int color,int bishopnum) {
        if(r>=N){
            if (color == 0){
                white = Math.max(white, bishopnum-2);
            } else {
                black = Math.max(black, bishopnum-2);
            }
            return;
        }
        if (c >= N){
            if (c%2==0){
                checkBishop(r+1,1,color,bishopnum);
            } else {
                checkBishop(r+1,0,color,bishopnum);
            }
            return;
        }

        // 비숍을 둘 수 없는 경우
        if (map[r][c]==0){
            checkBishop(r,c+2,color,bishopnum);
            return;
        }

        // 비숍을 둘수 있는 경우
        boolean canBishop = canBishop(r,c);
        if (canBishop){
            map[r][c] = bishopnum;
            checkBishop(r,c+2,color,bishopnum+1);
            map[r][c] = 1;
        }
        checkBishop(r,c+2,color,bishopnum);
    }

    private static boolean canBishop(int r, int c) {
        boolean isok = true;
        out:
        for (int dir = 0; dir < 4; dir++) {
            for (int l=1; l<N;++l){
                int nr = r+delta[0][dir]*l;
                int nc = c+delta[1][dir]*l;
                if (inRange(nr,nc)){
                    if (map[nr][nc]>1){
                        isok = false;
                        break out;
                    }
                } else {
                    break;
                }
            }
        }
        return isok;
    }

    private static boolean inRange(int row, int col) {
        if ((row >= 0) && (col >= 0) && (row < N) && (col < N)) return true;
        return false;
    }
}
