import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Set<Integer> known;
    public static class Party implements Comparable<Party> {
        List<Integer> memebers = new ArrayList<Integer>();

        @Override
        public int compareTo(Party o) {
            int knownThis = 0;
            for(int memeber : this.memebers){
                if(known.contains(memeber)){
                    knownThis++;
                }
            }
            int knownO = 0;
            for(int memeber : o.memebers){
                if(known.contains(memeber)){
                    knownO++;
                }
            }
            return Integer.compare(knownO, knownThis);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        known = new HashSet<Integer>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        str = br.readLine();
        st = new StringTokenizer(str);
        int k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < k; i++){
            known.add(Integer.parseInt(st.nextToken()));
        }
        PriorityQueue<Party> pq = new PriorityQueue<>();
        for(int i = 0; i < M; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            Party party = new Party();
            int p = Integer.parseInt(st.nextToken());
            for(int j = 0; j < p; j++){
                party.memebers.add(Integer.parseInt(st.nextToken()));
            }
            pq.add(party);
        }
        while(!pq.isEmpty()){
            Party party = pq.poll();
            int temp = 0;
            for(int memeber : party.memebers){
                if(known.contains(memeber)){
                    temp++;
                    break;
                }
            }
            if(temp == 0){
                pq.add(party);
                break;
            } else {
                known.addAll(party.memebers);
                List<Party> partys = new ArrayList<>();
                while(!pq.isEmpty()){
                    partys.add(pq.poll());
                }
                for(Party p : partys){
                    pq.add(p);
                }
            }
        }
        System.out.println(pq.size());
    }

}
