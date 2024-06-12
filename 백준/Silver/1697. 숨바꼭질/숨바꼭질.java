import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		if(N>=K) {
			System.out.println(N-K);
		} else {
			Set<Integer> set = new HashSet<>();
			Deque<Integer[]> deq = new ArrayDeque<>();
			Integer[] arr0 = { K, 0 };
			deq.add(arr0);
			set.add(K);
			while (true) {
				Integer[] arr1 = deq.pollFirst();
				if (!set.contains(arr1[0] + 1)) {
					Integer[] arr2 = {arr1[0] + 1, arr1[1] + 1};
					set.add(arr2[0]);
					deq.addLast(arr2);
//					System.out.println("+1");
//					System.out.println(Arrays.toString(arr2));
					if (arr2[0] == N) {
						System.out.println(arr2[1]);
						break;
					}
				}
				if ((arr1[0] - 1 >= 0) && (!set.contains(arr1[0] - 1))) {
					Integer[] arr2 = {arr1[0] - 1, arr1[1] + 1};
					set.add(arr2[0]);
					deq.addLast(arr2);
//					System.out.println("-1");
//					System.out.println(Arrays.toString(arr2));
					if (arr2[0] == N) {
						System.out.println(arr2[1]);
						break;
					}
				}
				if ((arr1[0]%2==0)&&(!set.contains(arr1[0] / 2))) {
					Integer[] arr2 = {arr1[0] / 2, arr1[1] + 1};
					set.add(arr2[0]);
					deq.addLast(arr2);
//					System.out.println("/2");
//					System.out.println(Arrays.toString(arr2));
					if (arr2[0] == N) {
						System.out.println(arr2[1]);
						break;
					}
				}
			}
		}
	}
}
