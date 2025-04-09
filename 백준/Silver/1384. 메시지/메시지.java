import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 1;
        StringBuilder sb = new StringBuilder();
        while(true){
            int n = Integer.parseInt(br.readLine());
            if (n == 0){
                break;
            } else {
                sb.append("Group ").append(tc).append("\n");
                String[] name = new String[n];
                char[][] message = new char[n][n-1];
                for (int i = 0; i < n; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    name[i] = st.nextToken();
                    for (int j = 0; j < n-1; j++) {
                        message[i][j] = st.nextToken().charAt(0);
                    }
                }
                boolean Nword = false;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n-1; j++) {
                        if (message[i][j] == 'N') {
                            Nword = true;
                            sb.append(name[(n-j-1+i)%n]).append(" was nasty about ").append(name[i]).append("\n");
                        }
                    }
                }
                if (!Nword) {
                    sb.append("Nobody was nasty").append('\n');
                }
                sb.append('\n');
                ++tc;
            }
        }
        System.out.println(sb);
    }
}
