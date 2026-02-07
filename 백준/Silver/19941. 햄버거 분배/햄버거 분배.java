import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        char[] arr = str.toCharArray();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                int min = Math.max(0, i-K);
                int max = Math.min(str.length()-1, i+K);
                for (int j = min; j <= max; j++) {
                    if (arr[j] == 'H') {
                        arr[j] = 'E';
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
