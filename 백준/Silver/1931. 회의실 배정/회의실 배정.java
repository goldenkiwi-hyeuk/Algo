import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Meeting implements Comparable<Meeting> {
        int start, end, time;

        public Meeting() {
        }

        public Meeting(int start, int end) {
            super();
            this.start = start;
            this.end = end;
            this.time = end - start;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end== o.end){
                return this.start - o.start;
            }else {
                return this.end - o.end;
            }
        }

        @Override
        public String toString() {
            return "Meeting [start=" + start + ", end=" + end + ", time=" + time + "]";
        }

    }

    static Meeting[] arr;
    static int cnt,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(str);
        PriorityQueue<Meeting> meetings = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < N; ++i) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Meeting meet = new Meeting(start, end);
            meetings.add(meet);
        }
        cnt = 0;
        int endTime = -1;
        while(!meetings.isEmpty()){
            Meeting meet = meetings.poll();
            if(meet.start>=endTime){
                ++cnt;
                endTime = meet.end;
            }
        }
        System.out.println(cnt);
    }
}
