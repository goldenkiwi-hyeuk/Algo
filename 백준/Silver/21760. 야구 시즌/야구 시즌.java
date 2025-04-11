import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int idx = 0;
            for (int i = 0; ; i++) {
                if (N * (M * (M - 1) / 2) * k * i + ((N * M)*(N*M-1)/2-(N * (M * (M - 1) / 2))) * i > D) {
                    idx = i;
                    break;
                }
            }
            if (idx == 0) {
                sb.append("-1").append('\n');
            } else {
                sb.append(N * (M * (M - 1) / 2) * k * (idx-1) + ((N * M)*(N*M-1)/2-(N * (M * (M - 1) / 2))) * (idx-1)).append('\n');
            }
        }
        System.out.println(sb);
    }
}
