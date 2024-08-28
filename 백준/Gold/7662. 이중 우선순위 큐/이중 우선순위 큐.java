import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            TreeMap<Long, Integer> map = new TreeMap<>();
            for(int i = 0 ; i < N ; i++) {
                String str = br.readLine();
                StringTokenizer st = new StringTokenizer(str);
                char command = st.nextToken().charAt(0);
                long num = Long.parseLong(st.nextToken());
                if(command == 'I'){
                    if(map.containsKey(num)){
                        map.put(num,map.get(num)+1);
                    } else {
                        map.put(num,1);
                    }
                } else {
                    if(num == 1){
                        try {
                            if(map.lastEntry().getValue()==1){
                                map.pollLastEntry();
                            } else {
                                map.put(map.lastKey(),map.lastEntry().getValue()-1);
                            }
                        } catch (Exception e){ }
                    } else {
                        try {
                            if(map.firstEntry().getValue()==1){
                                map.pollFirstEntry();
                            } else {
                                map.put(map.firstKey(),map.firstEntry().getValue()-1);
                            }
                        } catch (Exception e){ }
                    }
                }
            }
            if(map.size() == 0){
                sb.append("EMPTY").append("\n");
            } else if(map.size() == 1){
                sb.append(map.firstKey()).append(" ").append(map.firstKey()).append("\n");
            } else {
                sb.append(map.pollLastEntry().getKey()).append(" ").append(map.pollFirstEntry().getKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
