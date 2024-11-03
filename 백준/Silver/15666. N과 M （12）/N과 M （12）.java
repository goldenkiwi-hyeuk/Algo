import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static Integer[] arr;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        str = br.readLine();
        st = new StringTokenizer(str);
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        arr = set.toArray(new Integer[0]);
        Arrays.sort(arr);
        go(new int[M],0,0);
        System.out.println(sb);
    }

    private static void go(int[] numbers, int idx, int beforeidx) {
        if (idx == M) {
            for(int num : numbers) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = beforeidx; i < arr.length; i++) {
            numbers[idx] = arr[i];
            go(numbers, idx + 1, i);
        }
    }
}
