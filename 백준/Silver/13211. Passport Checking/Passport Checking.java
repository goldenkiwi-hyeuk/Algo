import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i = 0; i<N;++i){
            String passport = br.readLine();
            set.add(passport);
        }
        int cnt = 0;
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i<M;++i){
            String passport = br.readLine();
            if(set.contains(passport)) ++cnt;
        }
        System.out.println(cnt);
    }
}