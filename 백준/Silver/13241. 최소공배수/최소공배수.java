import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long gcd = getGcd(Math.max(A,B), Math.min(A,B));
        long A2 = A/gcd;
        long B2 = B/gcd;
        System.out.println(gcd*A2*B2);
    }

    private static long getGcd(long a, long b) {
        if (b==0){
            return a;
        } else {
            return getGcd(b,a%b);
        }
    }
}
