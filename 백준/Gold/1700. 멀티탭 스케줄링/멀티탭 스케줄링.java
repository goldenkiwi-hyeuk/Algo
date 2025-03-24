import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= K; i++) {
            list.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            list.get(arr[i]).add(i);
        }
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i <K ; ++i) {
            int target = arr[i];
            if (set.contains(target)) {
                continue;
            } else {
                if (set.size()<N){
                    set.add(target);
                } else {
                    int[][] arr2 = new int[N][2];
                    int idx = 0;
                    for (int device : set) {
                        arr2[idx][0] = device;
                        arr2[idx][1] = -1;
                        for (int j = 0; j<list.get(device).size(); j++) {
                            if (list.get(device).get(j)>i){
                                arr2[idx][1] = list.get(device).get(j);
                                break;
                            }
                        }
                        idx++;
                    }
                    int delete = -1;
                    int deleteIdx = -1;
                    for (int arr3[] : arr2){
                        if (arr3[1]==-1){ // 앞으로 사용되지 않는 경우
                            delete = arr3[0];
                            break;
                        } else {
                            if (arr3[1] > deleteIdx){ // 가장 늦게 사용될 기기를 선택
                                deleteIdx = arr3[1];
                                delete = arr3[0];
                            }
                        }
                    }
                    ++ans;
                    set.remove(delete);
                    set.add(target);
                }
            }
        }
        System.out.println(ans);
    }
}
