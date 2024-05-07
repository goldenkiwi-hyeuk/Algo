import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<>();
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			String command = sc.next();
			switch (command) {
			case "push_front": {
				deque.addFirst(sc.nextInt());
				break;
			}
			case "push_back": {
				deque.addLast(sc.nextInt());
				break;
			}
			case "pop_front": {
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.poll()).append("\n");
				}
				break;
			}
			case "pop_back": {
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.pollLast()).append("\n");
				}
				break;
			}
			case "size": {
				sb.append(deque.size()).append("\n");
				break;
			}
			case "empty" : {
				if(deque.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			}
			case "front" : {
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.peek()).append("\n");
				}
				break;
			}
			case "back" : {
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.peekLast()).append("\n");
				}
				break;
			}
			}
		}
		System.out.println(sb.toString());
	}
}
