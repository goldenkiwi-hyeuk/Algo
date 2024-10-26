import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        System.out.println(func(A,B,C));
    }
    public static long func(int A, int B, int C) {
        if(B==1) return A%C;

        long temp = func(A, B/2, C);
        if(B%2==0){
            return (temp*temp)%C;
        } else {
            return (((temp*temp)%C)*(A%C))%C;
        }
    }
}
