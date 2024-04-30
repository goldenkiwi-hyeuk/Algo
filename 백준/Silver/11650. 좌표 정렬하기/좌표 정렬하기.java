import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static class XY implements Comparable<XY> {
		int x, y;

		public XY() {
			// TODO Auto-generated constructor stub
		}

		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(XY o) {
			if(this.x!=o.x) {
				return this.x-o.x;
			} else {
				return this.y-o.y;
			}
		}

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		XY[] arr = new XY[N];
		for(int i = 0 ; i<N;++i) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			XY xy = new XY(x,y);
			arr[i] = xy;
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i<N;++i) {
			sb.append(arr[i].x).append(" ").append(arr[i].y);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
