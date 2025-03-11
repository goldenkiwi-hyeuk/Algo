import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String a = sc.nextLine();
        String str2 = sc.next();

        int[][] lcs = new int[str2.length()+1][str1.length()+1];
        for (int i = 1; i <= str2.length(); i++) {
            for (int j = 1; j <= str1.length(); j++) {
                if (str1.charAt(j-1) == str2.charAt(i-1)) {
                    lcs[i][j] = lcs[i-1][j-1]+1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        Deque<Character> deq = new ArrayDeque<>();
        int before = str1.length();
        int r = str2.length();
        int c = str1.length();
        while( r !=0 && c!= 0){
            if (lcs[r][c]== lcs[r-1][c]){
                --r;
            } else if (lcs[r][c] == lcs[r][c-1]){
                --c;
            } else{
                deq.addFirst(str2.charAt(r-1));
                --r;
                --c;
            }
        }


        if (deq.isEmpty()) {
            System.out.println(0);
        } else {
            StringBuilder sb = new StringBuilder(deq.peek());
            sb.append(deq.size()).append("\n");
            while (!deq.isEmpty()) {
                sb.append(deq.pollFirst());
            }
            System.out.println(sb);
        }

    }
}
