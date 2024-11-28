import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, min;
    static int[][] map;
    static int[][] delta = {{-1, 1, 0, 0}, {0, 0, -1, 1}};

    public static class Loc implements Comparable<Loc> {
        @Override
        public int compareTo(Loc o) {
            return this.cnt - o.cnt;
        }

        int r, c, cnt, breakPoint;

        public Loc() {
        }

        public Loc(int r, int c, int cnt, int breakPoint) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.breakPoint = breakPoint;
        }

        @Override
        public String toString() {
            return "Loc{" +
                    "r=" + r +
                    ", c=" + c +
                    ", cnt=" + cnt +
                    ", breakPoint=" + breakPoint +
                    '}';
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        min = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[N][M];
        boolean[][] visited2 = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        PriorityQueue<Loc> pq = new PriorityQueue<>();
        pq.add(new Loc(0, 0, 1, 1));
        out : while (!pq.isEmpty()) {
            Loc loc = pq.poll();
            for (int dir = 0; dir < 4; ++dir) {
                int nr = loc.r + delta[0][dir];
                int nc = loc.c + delta[1][dir];
                if (nr == N - 1 && nc == M - 1) {
                    min = loc.cnt+1;
                    break out ;
                }
                if ((nr>=0)&&(nr<N)&&(nc>=0)&&(nc<M)){
                    if (loc.breakPoint == 1){
                        if ((map[nr][nc]==0)&&(visited[nr][nc]==false)){
                            visited[nr][nc] = true;
                            visited2[nr][nc] = true;
                            pq.add(new Loc(nr,nc,loc.cnt+1,1));
                        } else if(map[nr][nc]==1&&visited2[nr][nc]==false){
                            visited2[nr][nc] = true;
                            pq.add(new Loc(nr,nc,loc.cnt+1,0));
                        }
                    } else {
                        if (map[nr][nc]==0&&visited2[nr][nc]==false){
                            visited2[nr][nc] = true;
                            pq.add(new Loc(nr,nc,loc.cnt+1,0));
                        }
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            if(N==1&&M==1){
                System.out.println(1);
            } else {
                System.out.println(-1);
            }
        } else {
            System.out.println(min);
        }
    }
}
