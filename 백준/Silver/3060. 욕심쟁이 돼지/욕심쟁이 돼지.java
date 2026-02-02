import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            long N = Long.parseLong(br.readLine());
            int day = 1;
            long total = 0;
            long[] current = new long[6];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                current[i]= Long.parseLong(st.nextToken());
                total += current[i];
            }

            while(total<=N){
                ++day;
                total *= 4;
                if(total>N) break;
            }
            sb.append(day).append("\n");
        }
        System.out.println(sb.toString());
    }
}
