import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer, Integer> ladder = new HashMap<>();
		for (int i = 0; i < N + M; ++i) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladder.put(a, b);
		}
		Queue<int[]> que = new ArrayDeque<>();
		int[] start = { 1, 0 };
		que.add(start);
		out: while (true) {
			int[] now = que.poll();
			int loc = now[0];
			int cnt = now[1] + 1;
			boolean gobest = false;
			for(int i = 6; i>0;--i) {
				loc = now[0];
				if(ladder.containsKey(loc+i)) {
					loc = ladder.get(loc+i);
					if(loc == 100) {
						System.out.println(cnt);
						break out;
					} else {
						int[] newloc = {loc,cnt};
						que.add(newloc);
					}
				} else {
					if(!gobest) {
						if(loc>=94) {
							System.out.println(cnt);
							break out;
						} else {
							loc += i ;
							int[] newloc = {loc,cnt};
							que.add(newloc);
							gobest = true;
						}
					}
				}
			}
		}
	}
}