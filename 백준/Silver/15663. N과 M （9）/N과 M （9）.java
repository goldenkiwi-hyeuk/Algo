import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        str = br.readLine();
        st = new StringTokenizer(str);
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
                list.add(num);
            }
        }
        Collections.sort(list);
        int[] arr = new int[M];
        check(0,arr);
        System.out.println(sb);
    }

    private static void check(int idx, int[] arr) {
        if(idx == M){
            for(int i =0;i<arr.length;i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i =0 ;i<list.size();i++){
            if(map.get(list.get(i))>0){
                arr[idx] = list.get(i);
                map.put(list.get(i), map.get(list.get(i))-1);
                check(idx+1, arr);
                map.put(list.get(i), map.get(list.get(i))+1);
            }
        }
    }
}
