import java.io.*;
import java.util.*;

class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        parent = new int[G+1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }
        int P = Integer.parseInt(br.readLine());
        int ans = 0;
        boolean isok = true;
        for (int i = 1; i <= P; i++) {
            int plane = Integer.parseInt(br.readLine());
            if(isok){
                if (plane == parent[plane]){
                    ans++;
                    parent[plane]--;
                } else {
                    int planeparent = findParent(plane);
                    if (parent[plane] != 0 ){
                        ans++;
                        parent[planeparent]--;
                    } else {
                        isok = false;
                    }
                }
            }
        }
        System.out.println(ans);
    }
    public static int findParent(int num){
        if (parent[num] == num){
            return num;
        }
        return parent[num] = findParent(parent[num]);
    }
}