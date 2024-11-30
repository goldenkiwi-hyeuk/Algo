import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] first = {1, 1, 1, 0};
    static long num = 1000000007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        if (n == 0) {
            System.out.println(0);
        } else {
            long[] numbers = pow(n);
            System.out.println(numbers[1]);
        }
    }

    private static long[] pow(long idx) {
        if (idx == 1) {
            return first;
        }
        if (idx % 2 == 0) {
            long[] temp = pow(idx / 2);
            return new long[]{((temp[0] * temp[0]) % num + (temp[1] * temp[2]) % num) % num,
                    ((temp[0] * temp[1]) % num + (temp[1] * temp[3]) % num) % num,
                    ((temp[2] * temp[0]) % num + (temp[3] * temp[2]) % num) % num,
                    ((temp[2] * temp[1]) % num + (temp[3] * temp[3]) % num) % num};
        } else {
            long[] temp = pow((idx-1) / 2);
            long[] temp2 = new long[]{((temp[0] * temp[0]) % num + (temp[1] * temp[2]) % num) % num,
                    ((temp[0] * temp[1]) % num + (temp[1] * temp[3]) % num) % num,
                    ((temp[2] * temp[0]) % num + (temp[3] * temp[2]) % num) % num,
                    ((temp[2] * temp[1]) % num + (temp[3] * temp[3]) % num) % num};
            return new long[]{(temp2[0] + temp2[2]) % num, (temp2[1] + temp2[3]) % num, temp2[0] % num, temp2[1] % num};
        }
    }
}
