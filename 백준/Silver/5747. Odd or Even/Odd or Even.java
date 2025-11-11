import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            int Xodd = 0;
            int Xeven = 0;
            int Yodd = 0;
            int Yeven = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num % 2 == 0) {
                    Xeven++;
                } else {
                    Xodd++;
                }
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num % 2 == 0) {
                    Yeven++;
                } else {
                    Yodd++;
                }
            }

            sb.append(N-(Math.min(Xeven, Yodd)+Math.min(Xodd, Yeven))).append("\n");
        }
        System.out.println(sb.toString());
    }
}
