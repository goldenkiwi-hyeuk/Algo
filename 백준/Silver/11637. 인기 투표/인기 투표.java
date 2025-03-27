import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int max = 0;
            int sum = 0;
            int maxidx = -1;
            for (int i = 0; i < N; i++) {
                int get = Integer.parseInt(br.readLine());
                sum += get;
                if (get > max) {
                    max = get;
                    maxidx = i+1;
                } else if (get == max) {
                    maxidx = -1;
                }
            }
            if (maxidx != -1) {
                if ((double)max/sum> 0.5){
                    sb.append("majority winner ").append(maxidx).append("\n");
                } else {
                    sb.append("minority winner ").append(maxidx).append("\n");
                }
            } else {
                sb.append("no winner").append("\n");
            }
        }
        System.out.println(sb);
    }
}
