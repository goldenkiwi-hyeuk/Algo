import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // A 찾기
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            nums.add(i);
        }
        Collections.shuffle(nums);

        int A = -1;
        for (int x : nums) {
            bw.write("? A " + x + "\n");
            bw.flush();
            String response = br.readLine();
            if (response != null && response.trim().equals("1")) {
                A = x;
                break;
            }
        }

        nums.clear();
        for (int i = 1; i <= 10000; i++) {
            nums.add(i);
        }
        Collections.shuffle(nums);

        int B = -1;
        for (int x : nums) {
            bw.write("? B " + x + "\n");
            bw.flush();
            String response = br.readLine();
            if (response != null && response.trim().equals("1")) {
                B = x;
                break;
            }
        }

        bw.write("! " + (A + B) + "\n");
        bw.flush();
    }
}
