import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (command == 0){
                int pa = findParent(a);
                int pb = findParent(b);
                union(pa,pb);
            } else {
                int pa = findParent(a);
                int pb = findParent(b);
                if (pa == pb){
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static void union(int num1, int num2) {
        int min = Math.min(num1,num2);
        int max = Math.max(num1,num2);
        parent[max] = min;
    }

    private static int findParent(int num) {
        if (parent[num] == num){
            return num;
        }
        return parent[num] = findParent(parent[num]);
    }
}
