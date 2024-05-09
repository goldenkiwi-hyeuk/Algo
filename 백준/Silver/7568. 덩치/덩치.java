import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static class Person {
		int weight, height, rank;

		public Person() {
			// TODO Auto-generated constructor stub
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Person> list = new ArrayList<>();
		for(int i =0; i<N;++i) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			Person p = new Person();
			p.weight = w;
			p.height = h;
			list.add(p);
		}
		for(int i = 0 ; i<N ; ++i ) {
			int rank = 1;
			Person p = list.get(i);
			for(int j=0; j<N;++j) {
				if((list.get(j).weight>p.weight)&&(list.get(j).height>p.height)){
					++rank;
				}
			}
			list.get(i).rank = rank;
		}
		for(int i =0; i<N;++i) {
			System.out.print(list.get(i).rank+" ");
		}
	}
}
