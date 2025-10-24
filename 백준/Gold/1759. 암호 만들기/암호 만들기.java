import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] alpabets;
    static char[] password;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        alpabets = new char[C];
        password = new char[L];
        sb = new StringBuilder();
        for (int i = 0; i < C; i++) {
            alpabets[i] = st.nextToken().toCharArray()[0];
        }
        Arrays.sort(alpabets);

        makePassword(0,0);

        System.out.println(sb.toString());
    }

    private static void makePassword(int idx, int cnt) {
        if (cnt == L){
            int aeiou = 0;
            int other = 0;
            for (int i = 0; i<L ; ++i){
                if (password[i] == 'a'||password[i] == 'e'||password[i] == 'i'||password[i] == 'o'||password[i] == 'u'){
                    ++aeiou;
                } else {
                    ++other;
                }
            }
            if (aeiou>=1 && other >=2){
                for (char c : password){
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = idx; i<C; ++i){
             password[cnt] = alpabets[i];
             makePassword(i+1, cnt+1);
        }
    }
}
