import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		Deque<Integer[]> que = new ArrayDeque<>();
		Set<Integer> set = new HashSet<>();
		Integer[] arr0 = {X,0};
		que.add(arr0);
		if(X==1) {
			System.out.println(0);
		} else {
			while(true) {
				Integer[] arr1 = que.poll();
				if(arr1[0]%3==0) {
					Integer[] arr2 = {arr1[0]/3,arr1[1]+1};
					if(!set.contains(arr2[0])) {
						if(arr2[0]==1) {
							System.out.println(arr2[1]);
							break;
						}
						que.add(arr2);
						set.add(arr2[0]);
					}
				}
				if(arr1[0]%2==0) {
					Integer[] arr2 = {arr1[0]/2,arr1[1]+1};
					if(!set.contains(arr2[0])) {
						if(arr2[0]==1) {
							System.out.println(arr2[1]);
							break;
						}
						que.add(arr2);
						set.add(arr2[0]);
					}
				}
				Integer[] arr2 = {arr1[0]-1,arr1[1]+1};
				if(!set.contains(arr2[0])) {
					if(arr2[0]==1) {
						System.out.println(arr2[1]);
						break;
					}
					que.add(arr2);
					set.add(arr2[0]);
				}
			}
		}
	}
}
