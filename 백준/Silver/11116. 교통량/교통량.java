import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc<T; ++tc){
            int m = Integer.parseInt(br.readLine());
            int cnt = 0;
            Set<Integer> left = new HashSet<>();
            Set<Integer> right = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<m ; ++i){
                left.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<m ; ++i){
                right.add(Integer.parseInt(st.nextToken()));
            }
            for(int num : left){
                if(left.contains(num+500)&&right.contains(num+1000)&&right.contains(num+1500)){
                    ++cnt;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb.toString());
    }
}