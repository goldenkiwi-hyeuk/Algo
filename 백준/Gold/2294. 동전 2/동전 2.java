import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1];
        Arrays.fill(dp, 987654321);
        Deque<int[]> deq = new ArrayDeque<>();
        deq.add(new int[]{0, 0});
        while (!deq.isEmpty()) {
            int[] cur = deq.pollFirst();
            if (cur[0] > k || dp[cur[0]] <= cur[1]) {
                continue;
            }

            dp[cur[0]] = cur[1];
            for (int i = 0; i < n; ++i) {
                int[] next = new int[2];
                next[0] = cur[0] + arr[i];
                next[1] = cur[1]+1;
                deq.addLast(next);
            }
        }

        if (dp[k] == 987654321) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
