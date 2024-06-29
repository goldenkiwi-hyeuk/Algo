import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Integer[] par;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		par = new Integer[N+1];
		for(int i=0; i<N+1;++i) {
			par[i] = i;
		}
		for(int i =0;i<M;++i) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			union(u,v);
		}
		for(int i =0; i<N+1;++i) {
			findpar(i);
		}
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(par));
		System.out.println(set.size()-1);
	}
	public static int findpar(int a){
		if(a== par[a]) {
			return a;
		} else {
			int parent = findpar(par[a]);
			par[a] = parent;
			return parent;
		}
	}
	
	public static void union (int u, int v){
		int parU = findpar(u);
		int parV = findpar(v);
		if(parU<=parV) {
			par[parV] = parU;
		} else {
			par[parU] = parV;
		}
		
	}
}
