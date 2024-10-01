import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        go(0);
        System.out.println(sb);
    }
    static void go(int idx){
        if(idx == M){
            for(int i =0; i<arr.length;++i){
                sb.append(arr[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        if(idx == 0){
            for(int i=1; i<=N; ++i) {
                arr[idx] = i;
                go(idx + 1);
            }
        } else {
            for(int i = arr[idx-1];i<=N;++i){
                arr[idx] = i;
                go(idx + 1);
            }
        }
    }
}
