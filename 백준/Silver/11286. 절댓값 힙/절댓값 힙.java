import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static class Number implements Comparable<Number>{

		int num;
		int abs;
		public Number() {
			// TODO Auto-generated constructor stub
		}
		public Number(int num) {
			this.num = num;
			this.abs = Math.abs(num);
		}
		
		@Override
		public int compareTo(Main.Number o) {
			if(this.abs == o.abs) {
				return this.num - o.num;
			} else {
				return this.abs - o.abs;
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Number> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i<N;++i) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(pq.poll().num).append("\n");
				}
			} else {
				Number number = new Number(num);
				pq.add(number);
			}
		}
		System.out.println(sb);
	}
}
