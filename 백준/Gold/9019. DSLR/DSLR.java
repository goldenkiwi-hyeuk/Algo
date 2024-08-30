import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<T; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Map<Integer, String> map = new HashMap<>();
            Queue<Integer> que = new ArrayDeque<>();
            map.put(start,"");
            que.add(start);
            while(!que.isEmpty()){
                int num = que.poll();
                int num2 = (num*2)%10000; // D
                if(!map.containsKey(num2)){
                    map.put(num2, map.get(num)+"D");
                    if(num2==end){
                        break;
                    }
                    que.add(num2);
                }
                int num3 = num-1==-1? 9999 : num-1; // S
                if(!map.containsKey(num3)){
                    map.put(num3, map.get(num)+"S");
                    if(num3==end){
                        break;
                    }
                    que.add(num3);
                }
                int num4 = (num%1000)*10+num/1000; // L
                if(!map.containsKey(num4)){
                    map.put(num4, map.get(num)+"L");
                    if(num4==end){
                        break;
                    }
                    que.add(num4);
                }
                
                int num5 = (num/10)+(num%10)*1000; // R
                if(!map.containsKey(num5)){
                    map.put(num5, map.get(num)+"R");
                    if(num5==end){
                        break;
                    }
                    que.add(num5);
                }
            }
            sb.append(map.get(end)).append("\n");
        }
        System.out.println(sb);
    }
}
