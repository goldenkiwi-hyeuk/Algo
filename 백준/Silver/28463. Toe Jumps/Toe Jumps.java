import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String,String>> map = new HashMap<>();
        map.put("E", new HashMap<String, String>());
        map.put("W", new HashMap<String, String>());
        map.put("S", new HashMap<String, String>());
        map.put("N", new HashMap<String, String>());

        // S방향
        map.get("S").put(".OP.","T");
        map.get("S").put("I..P","F");
        map.get("S").put("O..P","Lz");
        // N방향
        map.get("N").put(".PO.","T");
        map.get("N").put("P..I","F");
        map.get("N").put("P..O","Lz");
        // W방향
        map.get("W").put("P..O","T");
        map.get("W").put(".IP.","F");
        map.get("W").put(".OP.","Lz");
        // E방향
        map.get("E").put("O..P","T");
        map.get("E").put(".PI.","F");
        map.get("E").put(".PO.","Lz");

        String dir = br.readLine();
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = s1+s2;
        if (map.get(dir).containsKey(s3)) {
            System.out.println(map.get(dir).get(s3));
        } else {
            System.out.println("?");
        }
    }
}
