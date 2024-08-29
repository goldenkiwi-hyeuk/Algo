import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] delta = {{-1,1,0,0},{0,0,-1,1}};
    static boolean[][] visited;
    static int N;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        visited = new boolean[N][N];
        int colorCount = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j] == false) {
                    colorCount++;
                    char color = map[i][j];
                    visited[i][j] = true;
                    colorGo(i, j, color);
                }
            }
        }
        visited = new boolean[N][N];
        int noColorCount = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j] == false) {
                    noColorCount++;
                    char color = map[i][j];
                    visited[i][j] = true;
                    noColorGo(i, j, color);
                }
            }
        }
        System.out.println(colorCount+" " + noColorCount);
    }
    public static void colorGo(int r, int c, char color) {
        for(int dir = 0; dir<4;++dir){
            int nr = r + delta[0][dir];
            int nc = c + delta[1][dir];
            if((nr>=0)&&(nr<N)&&(nc>=0)&&(nc<N)&&(map[nr][nc]==color)&&(visited[nr][nc]==false)){
                visited[nr][nc] = true;
                colorGo(nr,nc,color);
            }
        }
    }

    public static void noColorGo(int r, int c, char color) {
        for(int dir = 0; dir<4;++dir){
            int nr = r + delta[0][dir];
            int nc = c + delta[1][dir];
            if((nr>=0)&&(nr<N)&&(nc>=0)&&(nc<N)&&(visited[nr][nc]==false)){
                if((color == 'R')||(color =='G')){
                    if (map[nr][nc] != 'B') {
                        visited[nr][nc] = true;
                        noColorGo(nr,nc,color);
                    }
                } else {
                    if (color == map[nr][nc]) {
                        visited[nr][nc] = true;
                        noColorGo(nr,nc,color);
                    }
                }
            }
        }
    }
}
