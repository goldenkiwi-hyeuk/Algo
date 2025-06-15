import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static class Score implements Comparable<Score> {
        private String name;
        private int Kscore, Escore, Mscore;

        public Score(String name, int Kscore, int Escore, int Mscore) {
            this.name = name;
            this.Kscore = Kscore;
            this.Escore = Escore;
            this.Mscore = Mscore;
        }

        public int compareTo(Score o) {
            if (this.Kscore == o.Kscore) {
                if (this.Escore == o.Escore) {
                    if (this.Mscore == o.Mscore) {
                        return this.name.compareTo(o.name);
                    }
                    return o.Mscore - this.Mscore;
                }
                return this.Escore - o.Escore;
            }
            return o.Kscore - this.Kscore;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Score[] scores = new Score[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int Kscore = Integer.parseInt(st.nextToken());
            int Escore = Integer.parseInt(st.nextToken());
            int Mscore = Integer.parseInt(st.nextToken());
            scores[i] = new Score(name, Kscore, Escore, Mscore);
        }
        Arrays.sort(scores);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< scores.length ; ++i) {
            sb.append(scores[i].name).append("\n");
        }
        System.out.println(sb.toString());
    }
}
