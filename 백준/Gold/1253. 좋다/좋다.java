import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans = 0;
        if (N > 2) {
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (i == j) {
                        continue;
                    }
                    int num = checkGood(i, j, 0, N - 1, arr[i] - arr[j], 0);
                    if (num != -1) {
                        ++ans;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static int checkGood(int num1, int num2, int left, int right, int target, int dir) {
        if (left > right) {
            return -1;
        }
        if (left < 0 || right >= N) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            if (mid == num1 || mid == num2) {
                if (dir == 1){
                    return checkGood(num1, num2, mid + 1, right, target, dir);
                } else {
                    return checkGood(num1, num2, left, mid-1, target, dir);
                }
            }
            return mid;
        } else if (arr[mid] < target) {
            return checkGood(num1, num2, mid + 1, right, target, 1);
        } else {
            return checkGood(num1, num2, left, mid - 1, target, -1);
        }
    }
}
