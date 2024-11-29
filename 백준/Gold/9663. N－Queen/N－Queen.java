import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static int cnt, N;
    static int[][] delta = {{-1,-1,0,1,1,1,0,-1},{0,1,1,1,0,-1,-1,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;
        map = new int[N][N];
        checkmap(1);
        System.out.println(cnt);
    }

    private static void checkmap(int num) {
        if(num == N){
            for (int i= 0;i < N; i++) {
                if(map[N-1][i]==0){
                    ++cnt;
                }
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if(map[num-1][i]==0){
                map[num-1][i] = num;
                for(int dir = 0; dir<8; dir++){
                    for (int j = 0; j < N; j++) {
                        int nr = num-1 + delta[0][dir]*j;
                        int nc = i + delta[1][dir]*j;
                        if ((nr>=0)&&(nr<N)&&(nc>=0)&&(nc<N)&&(map[nr][nc]==0)){
                            map[nr][nc] = num;
                        }
                    }
                }
                checkmap(num+1);
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if(map[j][k]==num){
                            map[j][k] = 0;
                        }
                    }
                }
            }
        }
    }
}
