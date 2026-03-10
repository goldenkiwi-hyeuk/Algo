import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m, total;
    static int[][] ground;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        ground = new int[n+1][m+1];
        for (int r = 1; r<=n;++r){
            for (int c = 1; c<=m;++c){
                ground[r][c] = 1;
                ++total;
            }
        }


        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1){
                int dy = Integer.parseInt(st.nextToken());
                int dx = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                cutGrass(dy,dx,y,x);
            } else if (command == 2){
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                sb.append(1-ground[y][x]).append("\n");
            } else if (command == 3) {
                sb.append(total).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static void cutGrass(int dy, int dx, int y, int x) {
        while(true){
            if ((y<1)||(y>n)||(x<1)||(x>m)){
                return;
            } else {
                if (ground[y][x] == 0){
                    return;
                } else {
                    ground[y][x] = 0;
                    --total;
                    y += dy;
                    x += dx;
                }
            }
        }
    }
}
