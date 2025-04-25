import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        out:
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                ++ans;
                int num = Integer.parseInt(st.nextToken());
                boolean isdone = checkBoard(num);
                if (isdone) {
                    break out;
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean checkBoard(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    board[i][j] = 0;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            int cnt1 = 0;
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == 0) {
                    cnt1++;
                }
            }
            if (cnt1 == 5) {
                ++cnt;
            }
        }
        for (int i = 0; i < 5; i++) {
            int cnt1 = 0;
            for (int j = 0; j < 5; j++) {
                if (board[j][i] == 0) {
                    cnt1++;
                }
            }
            if (cnt1 == 5) {
                ++cnt;
            }
        }
        int cnt1 = 0;
        for (int i = 0; i < 5; i++) {
            if (board[i][i] == 0) {
                cnt1++;
            }
        }
        if (cnt1 == 5) {
            ++cnt;
        }
        cnt1 = 0;
        for (int i = 0; i < 5; i++) {
            if (board[i][4 - i] == 0) {
                cnt1++;
            }
        }
        if (cnt1 == 5) {
            ++cnt;
        }
        if (cnt >= 3) {
            return true;
        } else {
            return false;
        }

    }
}
