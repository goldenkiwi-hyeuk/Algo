import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] delta = {{-1,1,0,0},{0,0,-1,1}};
    static int[][] box;
    static int done = 0;
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로
        box = new int[N][M];
        total = N*M;
        Queue<int[]> que = new ArrayDeque<int[]>();
        for(int r = 0 ; r<N;++r){
            str = br.readLine();
            st = new StringTokenizer(str);
            for(int c = 0 ; c<M;++c){
                box[r][c] = Integer.parseInt(st.nextToken());
                if(box[r][c]==1){
                    ++done;
                    que.add(new int[] {r,c,0});
                } else if(box[r][c]==-1){
                    --total;
                }
            }
        }
        if(que.isEmpty()){
            System.out.print(-1);
        }
        while(!que.isEmpty()){
            int[] loc = que.poll();
            for(int dir = 0; dir<4;++dir){
                int nr = loc[0] + delta[0][dir];
                int nc = loc[1] + delta[1][dir];
                if((nr>=0)&&(nr<N)&&(nc>=0)&&(nc<M)&&(box[nr][nc]==0)){
                    ++done;
                    box[nr][nc] = 1;
                    que.add(new int[] {nr,nc,loc[2]+1});
                }
            }
            if(que.isEmpty()){
                if(total==done){
                    System.out.print(loc[2]);
                } else {
                    System.out.print(-1);
                }
            }
        }

    }
}
