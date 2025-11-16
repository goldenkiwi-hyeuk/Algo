import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] pos = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pos[arr[i]] = i;
        }
        int[] cnt = new int[N+1];

        for (int i = 1; i < N; i++) {
            int correctValue = i;
            int idx = pos[correctValue];

            if (idx != i){
                int v1 = arr[i];
                int v2 = arr[idx];

                cnt[v1] += idx-i;
                cnt[v2] += idx-i;

                arr[i] = v2;
                arr[idx] = v1;

                pos[v1] = idx;
                pos[v2] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(cnt[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
