import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strs = str.split("-");
        long total = 0;
        try {
            total = Integer.parseInt(strs[0]);
        } catch (Exception e) {
            String[] numbers = strs[0].split("\\+");
            for(String num :numbers){
                total += Integer.parseInt(num);
            }
        }
        for(int i = 1 ; i<strs.length;++i){
            long totalnum = 0;
            try {
                totalnum = Integer.parseInt(strs[i]);
            } catch (Exception e) {
                String[] numbers = strs[i].split("\\+");
                for(String num :numbers){
                    totalnum += Integer.parseInt(num);
                }
            }
            total -= totalnum;
        }
        System.out.println(total);
    }
}
