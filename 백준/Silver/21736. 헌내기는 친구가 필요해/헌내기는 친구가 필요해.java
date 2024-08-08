import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] delta = {{-1,1,0,0},{0,0,-1,1}};
        char[][] map = new char[N][M];
        boolean[][] visit = new boolean[N][M];
        Deque<int[]> deque = new ArrayDeque<>();
        for(int i = 0; i<N;++i){
            str = br.readLine();
            for(int j = 0; j<M;++j){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='I'){
                    visit[i][j] = true;
                    int[] loc = {i,j};
                    deque.add(loc);
                }
            }
        }
        int cnt = 0;
        while(!deque.isEmpty()){
            int[] loc = deque.pollFirst();
            for(int dir =0; dir<4;++dir){
                int nr = loc[0]+delta[0][dir];
                int nc = loc[1]+delta[1][dir];
                if((nr>=0)&&(nr<N)&&(nc>=0)&&(nc<M)&&(visit[nr][nc]==false)&&(map[nr][nc]!='X')){
                    int[] newloc = {nr,nc};
                    visit[nr][nc] = true;
                    deque.add(newloc);
                    if(map[nr][nc]=='P'){
                        ++cnt;
                    }
                }
            }
        }
        if(cnt==0){
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
        
    }
}
