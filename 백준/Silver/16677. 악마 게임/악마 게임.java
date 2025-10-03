import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String m = br.readLine();
        int N = Integer.parseInt(br.readLine());
        double cnt = -1.0;
        String name = "No Jam";
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            int[][] dp = new int[m.length()+1][str.length()+1];
            for (int j = 1; j <= m.length(); j++) {
                for (int k = 1; k <= str.length(); k++) {
                    if (m.charAt(j-1) == str.charAt(k-1)) {
                        dp[j][k] = dp[j-1][k-1]+1;
                    } else {
                        dp[j][k] = Math.max(dp[j-1][k], dp[j][k-1]);
                    }
                }
            }

            if (dp[m.length()][str.length()] == m.length()) {
                double getValue = (double) value / (str.length()-m.length());
                if(getValue>cnt){
                    cnt = getValue;
                    name = str;
                }
            }
        }

        System.out.println(name);
    }
}
