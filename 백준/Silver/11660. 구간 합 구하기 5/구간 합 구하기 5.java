import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        for(int i = 1; i<=N;++i){
            str = br.readLine();
            st = new StringTokenizer(str);
            for(int j = 1; j<=N;++j){
                int num = Integer.parseInt(st.nextToken());
                if(j==1){
                    arr[i][j] = arr[i-1][j]+num;
                } else {
                    arr[i][j] = arr[i][j-1]+arr[i-1][j]+num-arr[i-1][j-1];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=M;++i){
            str = br.readLine();
            st = new StringTokenizer(str);
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1-1][y1-1]).append("\n");
        }
        System.out.println(sb);
    }
}
