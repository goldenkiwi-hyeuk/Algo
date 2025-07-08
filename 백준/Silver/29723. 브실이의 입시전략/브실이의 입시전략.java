import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Map<String, Integer> bsilResult = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            bsilResult.put(subject, score);
            resultList.add(score);
        }
        
        Collections.sort(resultList);
        int commonValue = 0;
        for (int i = 0; i < K; ++i) {
            String str = br.readLine();
            int score = bsilResult.get(str);
            commonValue += score;
            resultList.remove(new Integer(score));
        }
        
        int min = 0;
        for (int i = 0; i < M - K; ++i) {
            min += resultList.get(i);
        }

        int max = 0;
        for (int i = N - K - 1; i >= N - M; --i) {
            max += resultList.get(i);
        }
        
        System.out.println((commonValue + min) + " " + (commonValue + max));
    }
}
