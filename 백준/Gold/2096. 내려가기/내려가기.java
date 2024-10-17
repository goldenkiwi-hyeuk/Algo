import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] max = new int[N][3];
        int[][] min = new int[N][3];
        max[0] = arr[0];
        min[0] = arr[0];
        for (int i = 1; i < N; i++) {
            max[i][0] = Math.max(max[i - 1][0], max[i - 1][1])+arr[i][0];
            max[i][1] = Math.max(max[i-1][0],Math.max(max[i - 1][1], max[i - 1][2]))+arr[i][1];
            max[i][2] = Math.max(max[i - 1][1], max[i - 1][2])+arr[i][2];
            min[i][0] = Math.min(min[i - 1][0], min[i - 1][1])+arr[i][0];
            min[i][1] = Math.min(min[i-1][0],Math.min(min[i - 1][1], min[i - 1][2]))+arr[i][1];
            min[i][2] = Math.min(min[i - 1][1], min[i - 1][2])+arr[i][2];
        }
        System.out.println(Math.max(max[N-1][2],Math.max(max[N-1][0],max[N-1][1]))+" "+Math.min(Math.min(min[N-1][0],min[N-1][1]),min[N-1][2]));
    }
}
