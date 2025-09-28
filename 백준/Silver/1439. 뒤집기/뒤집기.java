import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int before = -1;
        int cnt = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) - 48 != before) {
                before = S.charAt(i) - 48;
                cnt++;
            }
        }

        System.out.println(cnt/2);
    }
}
