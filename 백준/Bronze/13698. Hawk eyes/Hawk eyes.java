import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] consoles = str.toCharArray();
		int[] arr = {1,0,0,2};
		for(char con : consoles) {
			if(con == 'A') {
				int temp = arr[0];
				arr[0] = arr[1];
				arr[1] = temp;
			} else if(con == 'B') {
				int temp = arr[0];
				arr[0] = arr[2];
				arr[2] = temp;
			} else if(con == 'C') {
				int temp = arr[0];
				arr[0] = arr[3];
				arr[3] = temp;
			} else if(con == 'D') {
				int temp = arr[1];
				arr[1] = arr[2];
				arr[2] = temp;
			} else if(con == 'E') {
				int temp = arr[1];
				arr[1] = arr[3];
				arr[3] = temp;
			} else if(con == 'F') {
				int temp = arr[2];
				arr[2] = arr[3];
				arr[3] = temp;
			}
		}
		for(int i = 0; i<4;++i) {
			if(arr[i]==1) {
				System.out.println(i+1);
				break;
			}
		}
		for(int i = 0; i<4;++i) {
			if(arr[i]==2) {
				System.out.println(i+1);
				break;
			}
		}
	}
}
