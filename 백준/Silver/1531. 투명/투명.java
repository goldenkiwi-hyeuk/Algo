import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] image = new int[101][101];
        for (int i = 0 ; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int r = x1; r<=x2; ++r){
                for(int c = y1; c<=y2; ++c){
                    ++image[r][c];
                }
            }
        }

        int ans = 0;

        for (int r = 1 ; r<=100; ++r){
            for (int c = 1 ; c<=100; ++c){
                if (image[r][c] > M){
                    ++ans;
                }
            }
        }

        System.out.println(ans);
    }
}
