import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Person implements Comparable<Person> {
        int v, p, s;
        int total;
        int idx;

        Person(){}

        Person(int v, int p, int s, int total, int idx) {
            this.v = v;
            this.p = p;
            this.s = s;
            this.total = total;
            this.idx = idx;
        }

        @Override
        public int compareTo(Person o) {
            return o.total - this.total;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int V0 = Integer.parseInt(st.nextToken());
        int P0 = Integer.parseInt(st.nextToken());
        int S0 = Integer.parseInt(st.nextToken());
        int sum = V0 + P0 + S0;
        PriorityQueue<Person> pq = new PriorityQueue();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            pq.add(new Person(v,p,s,v+p+s,i));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(0).append(" ");
        int cnt = 1;
        while (!pq.isEmpty()) {
            if (cnt>=M){
                break;
            }
            Person p = pq.poll();
            if (p.total> sum){
                continue;
            }

            sb.append(p.idx).append(" ");
            ++cnt;
        }
        System.out.println(sb.toString());
    }
}
