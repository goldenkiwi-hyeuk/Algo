import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            for(int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
        }
        int time = 0;
        while(map.firstKey()!=map.lastKey()) {
            if(map.firstEntry().getValue()<=B) {
                if(map.firstEntry().getValue()<=(map.lastEntry().getValue()*2)) {
                    time += map.firstEntry().getValue();
                    B -= map.firstEntry().getValue();
                    int key = map.firstKey()+1;
                    int value = map.firstEntry().getValue();
                    map.remove(map.firstKey());
                    if(map.containsKey(key)) {
                        map.put(key, map.get(key)+value);
                    } else {
                        map.put(key, value);
                    }
                } else if(map.firstEntry().getValue()>(map.lastEntry().getValue()*2)) {
                    time += map.lastEntry().getValue()*2;
                    B += map.lastEntry().getValue();
                    int key = map.lastKey()-1;
                    int value = map.lastEntry().getValue();
                    map.remove(map.lastKey());
                    if(map.containsKey(key)) {
                        map.put(key, map.get(key)+value);
                    } else {
                        map.put(key, value);
                    }
                }
            } else {
                time += map.lastEntry().getValue()*2;
                B += map.lastEntry().getValue();
                int key = map.lastKey()-1;
                int value = map.lastEntry().getValue();
                map.remove(map.lastKey());
                if(map.containsKey(key)) {
                    map.put(key, map.get(key)+value);
                } else {
                    map.put(key, value);
                }
            }
        }
        System.out.println(time + " " + map.firstKey());
    }
}
