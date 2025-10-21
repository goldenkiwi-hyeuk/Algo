import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int INF = 987654321;
        int[][] arr = new int[N+1][N+1];
        for (int i = 0; i<=N;++i){
            Arrays.fill(arr[i], INF);
        }

        for (int i = 1; i<=N;++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j<=N;++j){
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    arr[i][j] = 1;
                }
                if (i==j){
                    arr[i][j] = 0;
                }
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean flag = true;
        int before = Integer.parseInt(st.nextToken());
        for (int i = 0; i<M-1;++i){
            int target = Integer.parseInt(st.nextToken());
            if (arr[before][target]<INF){
                before = target;
            } else {
                flag = false;
                break;
            }
        }

        if (flag){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
