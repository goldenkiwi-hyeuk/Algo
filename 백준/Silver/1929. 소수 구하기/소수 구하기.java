import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		if (N == 1) {
		} else if (M == 1) {
			M += 1;
			boolean[] check = new boolean[N + 1];
			for (int i = 2; i < ((int) Math.sqrt(N)) + 1; ++i) {
				int data = i;
				int cnt =  2;
				while (true) {
					if ((data * cnt) <= N) {
						check[data * cnt] = true;
					}else {
						break;
					}
					++cnt;
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int i = M; i < N + 1; ++i) {
				if (check[i] == false) {
					sb.append(i).append("\n");
				}
			}
			System.out.println(sb);

		} else {
			boolean[] check = new boolean[N + 1];
			for (int i = 2; i < ((int) Math.sqrt(N)) + 1; ++i) {
				int data = i;
				int cnt = 2;
				while (true) {
					if ((data * cnt) <= N) {
						check[data * cnt] = true;
					}else {
						break;
					}
					++cnt;
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int i = M; i < N + 1; ++i) {
				if (check[i] == false) {
					sb.append(i).append("\n");
				}
			}
			System.out.println(sb);

		}
	}
}
