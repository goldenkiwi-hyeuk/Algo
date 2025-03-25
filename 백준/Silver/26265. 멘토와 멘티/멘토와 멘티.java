import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class MentoMenti implements Comparable<MentoMenti> {
        String Mento, Menti;

        public MentoMenti(String Mento, String Menti) {
            this.Mento = Mento;
            this.Menti = Menti;
        }

        @Override
        public int compareTo(MentoMenti o) {
            if (!this.Mento.equals(o.Mento)) {
                return this.Mento.compareTo(o.Mento);
            } else {
                return o.Menti.compareTo(this.Menti);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<MentoMenti> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String Mento = st.nextToken();
            String Menti = st.nextToken();
            pq.add(new MentoMenti(Mento, Menti));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            MentoMenti m = pq.poll();
            sb.append(m.Mento).append(" ").append(m.Menti).append("\n");
        }
        System.out.println(sb);
    }
}
