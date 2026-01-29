import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] primes = new boolean[100000001];
        for (int i = 2; i < 10001; i++) {
            if (!primes[i]) {
                for (int j = 2; i*j < 100000001; j++) {
                    primes[i*j] = true;
                }
            }
        }

        int count = 0;
        int target = -1;
        for (int i = 2; i < 100000001; i++) {
            if (!primes[i]) {
                ++count;
                if (count == n) {
                    target = i;
                }
            }
        }

        System.out.println(target);
    }
}
