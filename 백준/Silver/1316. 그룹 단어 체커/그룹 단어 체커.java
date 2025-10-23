import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char before = str.charAt(0);
            Set<Character> set = new HashSet<>();
            boolean flag = true;
            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(j) == before){
                    continue;
                } else if(set.contains(str.charAt(j))) {
                    flag = false;
                } else {
                    set.add(before);
                    before = str.charAt(j);
                }
            }
            if (flag) {
                ++cnt;
            }
        }
        System.out.println(cnt);
    }
}
