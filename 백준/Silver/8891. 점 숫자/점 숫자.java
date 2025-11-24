import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Integer, Integer> map1;
    static Map<Integer, Integer> map2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        firstinit();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int x1 = map2.get(num1)/10000;
            int y1 = map2.get(num1)%10000;
            int x2 = map2.get(num2)/10000;
            int y2 = map2.get(num2)%10000;
            int x3 = x1+x2;
            int y3 = y1+y2;
            sb.append(map1.get(x3*10000+y3)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void firstinit() {
        map1 = new HashMap<Integer, Integer>();
        map2 = new HashMap<Integer, Integer>();
        int num = 1;
        int x = 1;
        int y = 1;
        while(num<=100000){
            map1.put(x*10000+y, num);
            map2.put(num, x*10000+y);
            ++x;
            --y;
            if (y==0){
                y = x;
                x = 1;
            }
            ++num;
        }
    }
}
