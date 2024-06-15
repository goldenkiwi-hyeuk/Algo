import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] parent;
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		parent = new int[N+1];
		for(int i=0;i<N+1;++i) {
			parent[i]=i;
		}
		int edge = sc.nextInt();
		for(int ed=0; ed<edge;++ed) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int pn = find(n);
			int pm = find(m);
			if(pn<=pm) {
				for(int i=2;i<N+1;++i) {
					if(parent[i]==pm) {
						parent[i] = pn;
					}
				}
			} else {
				for(int i=2;i<N+1;++i) {
					if(parent[i]==pn) {
						parent[i] = pm;
					}
				}
			}
		}
		int ans = 0;
		for(int i=2;i<N+1;++i) {
			if(parent[i]==1) {
				++ans;
			}
		}
		System.out.println(ans);
	}
	public static int find(int num) {
		if(parent[num]== num) {
			return num;
		} else {
			int ans = find(parent[num]);
			return ans;
		}
	}
}
