import java.util.*;
import java.io.*;

class Main {
    static Map<String, Double> mapping;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double totalTime = 0;
        double sum = 0;
        mapping = new HashMap<>();
        mapping.put("A+", 4.5);
        mapping.put("A0", 4.0);
        mapping.put("B+", 3.5);
        mapping.put("B0", 3.0);
        mapping.put("C+", 2.5);
        mapping.put("C0", 2.0);
        mapping.put("D+", 1.5);
        mapping.put("D0", 1.0);
        mapping.put("F", 0.0);
        for(int i = 0; i<20; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double time  = Double.parseDouble(st.nextToken());
            String result = st.nextToken();
            if(mapping.containsKey(result)){
                totalTime += time;
                sum += mapping.get(result)*time;
            }
        }
        System.out.printf("%.6f",sum / totalTime);
    }
}