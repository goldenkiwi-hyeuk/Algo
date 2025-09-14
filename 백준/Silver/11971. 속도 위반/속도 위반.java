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
        int[] limitArr = new int[101];
        int current = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dist = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int j = 0; j < dist; j++) {
                limitArr[current++] += speed;
            }
        }

        current = 0;
        int[] speedArr = new int[101];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int dist = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int j = 0; j < dist; j++) {
                speedArr[current++] += speed;
            }
        }

        int ans = 0;
        for (int i = 0; i < 101; i++) {
            ans = Math.max(ans, speedArr[i] - limitArr[i]);
        }

        System.out.println(ans);
    }
}
