import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static class Atm implements Comparable<Atm> {
		int time;

		public Atm() {
			// TODO Auto-generated constructor stub
		}

		public Atm(int time) {
			this.time = time;
		}

		@Override
		public int compareTo(Atm o) {
			return this.time - o.time;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Atm> pq = new PriorityQueue<>();
		for (int i = 0; i < N; ++i) {
			Atm atm = new Atm(sc.nextInt());
			pq.add(atm);
		}
		int ans = 0;
		for (int i = 0; i < N; ++i) {
			Atm atm = pq.poll();
			ans += atm.time * (N - i);
		}
		System.out.println(ans);
	}
}
