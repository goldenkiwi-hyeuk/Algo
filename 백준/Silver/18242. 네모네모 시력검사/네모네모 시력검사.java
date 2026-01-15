import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static char[][] map;
    static int[][] delta = {{-1,1,0,0},{0,0,-1,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        out : for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '#') {
                    int lenUp = checkLen(i,j,3);
                    int lenLeft = checkLen(i,j,1);

                    if (lenLeft > lenUp) {
                        System.out.println("UP");
                    } else if (lenLeft < lenUp) {
                        System.out.println("LEFT");
                    }
                    break out;
                }
            }
        }

        out : for (int i = N-1; i >=0 ; i--) {
            for (int j = M-1; j >= 0; j--) {
                if (map[i][j] == '#') {
                    int lenDown = checkLen(i,j,2);
                    int lenRight = checkLen(i,j,0);

                    if (lenRight > lenDown) {
                        System.out.println("DOWN");
                    } else if (lenRight < lenDown) {
                        System.out.println("RIGHT");
                    }
                    break out;
                }
            }
        }
    }

    static int checkLen(int i, int j, int dir) {
        int len = 1;
        while(true){
            i += delta[0][dir];
            j += delta[1][dir];
            if (inRange(i,j)){
                if (map[i][j] == '#') {
                    len++;
                } else {
                    return len;
                }
            } else {
                return len;
            }
        }
    }

    static boolean inRange(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < M;
    }
}
