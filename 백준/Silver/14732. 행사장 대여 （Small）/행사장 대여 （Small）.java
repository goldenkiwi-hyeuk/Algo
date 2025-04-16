import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[501][501];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int r = y1+1; r <= y2; r++) {
                for (int c = x1+1; c <= x2; c++) {
                    map[r][c] = true;
                }
            }
        }

        int ans = 0;
        for(int r= 0; r<501; r++) {
            for(int c= 0; c<501; c++) {
                if(map[r][c]) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
