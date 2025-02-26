import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        int ans = 0;
        boolean findans = false;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (findans) {
                continue;
            }
            int pa = findParent(a);
            int pb = findParent(b);
            if (pa == pb) {
                ans = i;
                findans = true;
            } else {
                int min = Math.min(pa, pb);
                int max = Math.max(pa, pb);
                parent[max] = min;
            }
        }

        System.out.println(ans);
    }

    private static int findParent(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = findParent(parent[a]);
    }
}