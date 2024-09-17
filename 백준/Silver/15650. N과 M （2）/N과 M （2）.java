import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N+1];
        check(1, 0);
        System.out.println(sb);
    }
    private static void check(int num, int cnt){
        if(cnt == M){
            for(int i = 0; i<M;++i){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        if(num>N){
            return;
        }
        if(!visit[num]){
            visit[num] = true;
            arr[cnt] = num;
            check(num+1, cnt+1);
            check(num+1, cnt);
            visit[num] = false;
        }
    }
}
