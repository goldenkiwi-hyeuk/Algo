import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int[][] delta = {{-1,1,-0,0},{0,0,-1,1}};
    static int[][] map;
    static int N,idx,cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        List<Integer> list = new ArrayList<>();
        idx = 2;
        for(int r=0;r<N;++r) {
            String str = br.readLine();
            char[] chars = str.toCharArray();
            for (int c = 0; c < N; ++c) {
                map[r][c] = Integer.parseInt(String.valueOf(chars[c]));
            }
        }
        for(int r=0;r<N;++r){
            for(int c=0;c<N;++c){
                if(map[r][c]==1){
                    cnt = 0;
                    map[r][c]=idx;
                    dfs(r, c);
                    list.add(cnt);
                    ++idx;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(idx-2).append("\n");
        Collections.sort(list);
        for(Integer num :list){
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int r, int c){
        ++cnt;
        for(int dir=0; dir<4;++dir){
            int nr = r+delta[0][dir];
            int nc = c+delta[1][dir];
            if((nr<N)&&(nr>=0)&&(nc<N)&&(nc>=0)&&(map[nr][nc])==1){
                map[nr][nc]=idx;
                dfs(nr,nc);
            }
        }
    }
}
