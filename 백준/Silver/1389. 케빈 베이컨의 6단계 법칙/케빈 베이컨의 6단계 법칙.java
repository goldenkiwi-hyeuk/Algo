import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(arr[i],INF);
        }
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        for (int i = 1; i <= N; i++) {
            arr[i][i] = 0;
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    arr[i][k] = Math.min(arr[i][k], arr[i][j]+arr[j][k]);
                    arr[k][i] = Math.min(arr[k][i], arr[i][j]+arr[j][k]);
                }
            }
        }
        int min = INF;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            int total = 0;
            for (int j = 1; j <= N; j++) {
                total += arr[i][j];
            }
            if(min>total){
                min=total;
            }
            if(map.containsKey(total)){
                map.get(total).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(total, list);
            }
        }
        System.out.println(map.get(min).get(0));
    }
}