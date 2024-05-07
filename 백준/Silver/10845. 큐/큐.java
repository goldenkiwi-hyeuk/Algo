import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> que = new LinkedList<>();
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			String command = sc.next();
			switch (command) {
			case "push": {
				que.add(sc.nextInt());
				break;
			}
			case "pop": {
				if(que.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(que.poll()).append("\n");
				}
				break;
			}
			case "size": {
				sb.append(que.size()).append("\n");
				break;
			}
			case "empty" : {
				if(que.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			}
			case "front" : {
				if(que.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(que.peek()).append("\n");
				}
				break;
			}
			case "back" : {
				if(que.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(que.toArray()[que.size()-1]).append("\n");
				}
				break;
			}
			}
		}
		System.out.println(sb.toString());
	}
}
