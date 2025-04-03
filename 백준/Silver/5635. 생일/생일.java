import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int minYear = 9999;
        int minMonth = 9999;
        int minDay = 9999;
        int maxYear = 0;
        int maxMonth = 0;
        int maxDay = 0;
        String minName = "";
        String maxName = "";
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            if(year < minYear){
                minYear = year;
                minMonth = month;
                minDay = day;
                minName = name;
            } else if(year == minYear){
                if(month < minMonth){
                    minMonth = month;
                    minDay = day;
                    minName = name;
                } else if(month == minMonth){
                    if(day < minDay){
                        minDay = day;
                        minName = name;
                    }
                }
            }

            if(year > maxYear){
                maxYear = year;
                maxMonth = month;
                maxDay = day;
                maxName = name;
            } else if(year == maxYear){
                if(month > maxMonth){
                    maxMonth = month;
                    maxDay = day;
                    maxName = name;
                } else if(month == minMonth){
                    if(day > maxDay){
                        maxDay = day;
                        maxName = name;
                    }
                }
            }
        }
        System.out.println(maxName);
        System.out.println(minName);
    }
}
