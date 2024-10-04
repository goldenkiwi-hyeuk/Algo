import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int answer = N;
        if(P>=5){
            answer = N-500;
            if(answer <0) answer = 0;
        }
        if (P>=10){
            answer = answer<(N/10)*9? answer : (N/10)*9;
        }
        if (P>=15){
            answer = answer<N-2000? answer : N-2000;
            if(answer <0) answer = 0;
        }
        if (P>=20){
            answer = answer<(N/4)*3? answer : (N/4)*3;
        }
        System.out.println(answer);
    }
}
