import java.util.Arrays;
import java.util.Scanner;

class Loc implements Comparable<Loc> {
	int x, y;

	public Loc() {
		// TODO Auto-generated constructor stub
	}

	public Loc(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Loc o) {
		if (this.y == o.y) {
			return this.x - o.x;
		} else {
			return this.y - o.y;
		}
	}

}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Loc[] arr = new Loc[N];
		for (int i = 0; i < N; ++i) {
			Loc loc = new Loc(sc.nextInt(), sc.nextInt());
			arr[i] = loc;
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; ++i) {
			Loc loc = arr[i];
			sb.append(loc.x).append(" ").append(loc.y).append("\n");
		}
		System.out.println(sb.toString());
	}
}
