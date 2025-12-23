import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static class SSN implements Comparable<SSN> {
        String ssn;
        int first, second, third;

        public SSN(){}

        public SSN(String ssn, int first, int second, int third) {
            this.ssn = ssn;
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public int compareTo(SSN o) {
            if (this.first == o.first) {
                if (this.second == o.second) {
                    return this.third - o.third;
                }
                return this.second - o.second;
            }
            return this.first - o.first;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        PriorityQueue<SSN> pq = new PriorityQueue<>();
        try {
            while (true) {
                String ssn = br.readLine();
                if (set.contains(ssn) && !set2.contains(ssn)) {
                    StringTokenizer st = new StringTokenizer(ssn,"-");
                    int first = Integer.parseInt(st.nextToken());
                    int second = Integer.parseInt(st.nextToken());
                    int third = Integer.parseInt(st.nextToken());
                    pq.add(new SSN(ssn, first, second, third));
                    set2.add(ssn);
                } else {
                    set.add(ssn);
                }
            }
        } catch (Exception e){
            while(!pq.isEmpty()){
                SSN ssn = pq.poll();
                sb.append(ssn.ssn).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
