import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < T; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int gfc = find(Math.max(M,N),Math.min(M,N));
            long maximum = (M/gfc)*(N/gfc)*gfc;
            int idx = 0;
            boolean isNotOk = true;
            while(M*idx+x<=maximum) {
                long year = M*idx+x;
                if((year-y)%N==0){
                    sb.append(year).append("\n");
                    isNotOk = false;
                    break;
                } else {
                    ++idx;
                }
            }
            if(isNotOk) {
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static int find(int a, int b){
        if(b==0){
            return a;
        }
        return find(b,a%b);
    }
}
