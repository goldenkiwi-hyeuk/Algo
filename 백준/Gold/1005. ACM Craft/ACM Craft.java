import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Work implements Comparable<Work> {
        int idx, starttime, endtime;

        public Work(){}

        public Work(int idx, int starttime, int endtime) {
            this.idx = idx;
            this.starttime = starttime;
            this.endtime = endtime;
        }

        @Override
        public int compareTo(Work o) {
            return this.endtime - o.endtime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr1 = new int[N+1];
            int[] arr2 = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr1[j] = Integer.parseInt(st.nextToken());
            }
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i<=N; ++i){
                list.add(new ArrayList<Integer>());
            }
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                ++arr2[end];
                list.get(start).add(end);
            }
            int target = Integer.parseInt(br.readLine());
            PriorityQueue<Work> pq = new PriorityQueue<>();
            for (int i = 1; i<=N; ++i){
                if (arr2[i]==0){
                    pq.add(new Work(i,0,arr1[i]));
                }
            }
            int time = 0;
            while (!pq.isEmpty()){
                Work w = pq.poll();
                if (w.endtime>time){
                    time = w.endtime;
                }
                if (w.idx == target){
                    break;
                }
                for (int num : list.get(w.idx)){
                    arr2[num]--;
                    if (arr2[num]==0){
                        pq.add(new Work(num,time,time+arr1[num]));
                    }
                }
            }
            sb.append(time).append("\n");
        }
        System.out.println(sb);
    }
}
