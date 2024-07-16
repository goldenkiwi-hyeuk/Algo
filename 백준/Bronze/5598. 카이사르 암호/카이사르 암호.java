import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		for(char alpa : str.toCharArray()) {
			if(alpa == 'A') {
				sb.append('X');
			} else if(alpa == 'B') {
				sb.append('Y');
			} else if (alpa == 'C') {
				sb.append('Z');
			} else {
				sb.append((char) (((int) alpa -65-3)%26+65));
			}
		}
		System.out.println(sb);
	}
}
//ABCDEFGHIJKLMNOPQRSTUVWXYZ