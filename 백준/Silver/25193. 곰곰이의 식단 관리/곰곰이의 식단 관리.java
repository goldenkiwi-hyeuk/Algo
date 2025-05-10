import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int cCnt = 0;
        for (int i = 0; i < N; i++) {
            if (str.charAt(i) == 'C') {
                ++cCnt;
            }
        }
        System.out.println((int)Math.ceil(cCnt/((double)N-cCnt + 1)));
    }
}
