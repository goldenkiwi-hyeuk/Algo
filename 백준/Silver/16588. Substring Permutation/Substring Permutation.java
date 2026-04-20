import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] Sarr, Parr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        Sarr = new int[26];
        for (int i = 0; i < S.length(); i++) {
            int num = (int) S.charAt(i) - 'a';
            Sarr[num]++;
        }
        String P = br.readLine();
        Parr = new int[26];
        for (int i = 0; i < P.length(); i++) {
            int num = (int) P.charAt(i) - 'a';
            Parr[num]++;
        }

        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (Sarr[i] < Parr[i]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
