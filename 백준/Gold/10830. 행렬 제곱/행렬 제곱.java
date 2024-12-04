import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long B;
    static int mod = 1000;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] answer = getpow(B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] getpow(long b) {
        if (b == 1) {
            int[][] temp = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[i][j] = A[i][j] % mod;
                }
            }
            return temp;
        }
        if (b % 2 == 0) {
            int[][] temp = getpow(b / 2);
            return multiply(temp, temp);
        } else {
            int[][] temp = getpow(b / 2);
            return multiply(multiply(temp, temp), A);
        }
    }

    private static int[][] multiply(int[][] temp1, int[][] temp2) {
        int[][] answer = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = 0;
                for (int k = 0; k < N; k++) {
                    num = ((temp1[i][k] * temp2[k][j]) % mod + (num % mod)) % mod;
                }
                answer[i][j] = num;
            }
        }
        return answer;
    }
}
