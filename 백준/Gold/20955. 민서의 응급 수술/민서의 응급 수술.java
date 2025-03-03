import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        ans = 0;
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u,v);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(findParent(i));
        }
        System.out.println(set.size()-1 + ans);
    }

    private static int findParent(int num) {
        if(num == parent[num]){
            return num;
        }
        return parent[num] = findParent(parent[num]);
    }

    private static void union(int num1, int num2) {
        int num1P = findParent(num1);
        int num2P = findParent(num2);
        if(num1P > num2P){
            parent[num1P] = num2P;
        } else if (num2P > num1P){
            parent[num2P] = num1P;
        } else {
            ans++;
        }
    }
}
