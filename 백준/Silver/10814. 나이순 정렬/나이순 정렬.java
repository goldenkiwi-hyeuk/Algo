import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static class AgeName implements Comparable<AgeName> {
		int age;
		String name;
		int order;

		public AgeName() {
		}

		@Override
		public int compareTo(AgeName o) {
			if(this.age!=o.age) {
				return this.age-o.age;
			} else {
				return this.order-o.order;
			}
			
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		AgeName[] arr = new AgeName[N];
		for(int i = 0; i<N;++i) {
			int age = sc.nextInt();
			String name = sc.next();
			int order  = i;
			AgeName person = new AgeName();
			person.age = age;
			person.name = name;
			person.order = order;
			arr[i] = person;
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N;++i) {
			sb.append(arr[i].age + " "+ arr[i].name+"\n");
		}
		System.out.println(sb.toString());
	}
}
