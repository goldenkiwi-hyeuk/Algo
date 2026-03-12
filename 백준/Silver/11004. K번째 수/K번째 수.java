import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; ++i){
            int num = Integer.parseInt(st.nextToken()); 
            pq.add(num);
        }
        for(int i = 0; i<K-1; ++i){
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}