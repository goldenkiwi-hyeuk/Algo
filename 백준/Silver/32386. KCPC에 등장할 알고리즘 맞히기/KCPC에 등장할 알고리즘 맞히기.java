import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for (int j = 0; j<t; ++j){
                String str = st.nextToken();
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        int num = 0;
        String name ="";
        boolean flag = false;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > num) {
                num = entry.getValue();
                name = entry.getKey();
                flag = false;
            } else if (entry.getValue() == num) {
                flag = true;
            }
        }

        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(name);
        }
    }
}
