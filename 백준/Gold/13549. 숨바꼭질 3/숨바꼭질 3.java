import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static class Loc implements Comparable<Loc> {

        int loc, cnt;

        Loc() {
        }

        Loc(int loc, int cnt) {
            this.loc = loc;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Loc o) {
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Loc> locs = new PriorityQueue<>();
        Loc location = new Loc();
        location.loc = K;
        location.cnt = 0;
        locs.add(location);
        Set<Integer> set = new HashSet<>();
        if (K == N) {
            System.out.println(0);
        } else {
            while (!locs.isEmpty()) {
                Loc loc = locs.poll();
                if(loc.loc == N){
                    System.out.println(loc.cnt);
                    break;
                } else {
                    if (set.contains(loc.loc)) {
                        continue;
                    } else {
                        set.add(loc.loc);
                    }
                }
                if (loc.loc % 2 == 0 && loc.loc != 0) {
                    Loc loc2 = new Loc(loc.loc / 2, loc.cnt);
                    locs.add(loc2);
                    Loc left = new Loc(loc.loc - 1, loc.cnt + 1);
                    Loc right = new Loc(loc.loc + 1, loc.cnt + 1);
                    locs.add(left);
                    locs.add(right);
                } else {
                    Loc left = new Loc(loc.loc - 1, loc.cnt + 1);
                    Loc right = new Loc(loc.loc + 1, loc.cnt + 1);
                    locs.add(left);
                    locs.add(right);
                }
            }
        }
    }
}
