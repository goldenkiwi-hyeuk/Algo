import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int[] arr = new int[N];
        for(int i=0; i<N;++i){
            int key = Integer.parseInt(st.nextToken());
            arr[i] = key;
            if(!map.containsKey(key)){
                map.put(key,1);
            }
        }
        int[] arr2 = map.keySet().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr2);
        for(int i=0; i<arr2.length;++i){
            map.put(arr2[i],i);
        }
        StringBuilder sb = new StringBuilder();
        for(int key : arr){
            sb.append(map.get(key)).append(" ");
        }
        System.out.println(sb);
    }
}
