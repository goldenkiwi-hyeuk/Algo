import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<Integer,Integer> map=new HashMap<>();
    static boolean flag = false;
    static int[] check = new int[6];
    static int[] arr = new int[6];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        map.put(0,6);
        map.put(1,2);
        map.put(2,5);
        map.put(3,5);
        map.put(4,4);
        map.put(5,5);
        map.put(6,6);
        map.put(7,3);
        map.put(8,7);
        map.put(9,6);

        makeNum(0,N-4);

        if (flag){
            System.out.print(arr[0]);
            System.out.print(arr[1]);
            System.out.print("+");
            System.out.print(arr[2]);
            System.out.print(arr[3]);
            System.out.print("=");
            System.out.print(arr[4]);
            System.out.print(arr[5]);
        } else {
            System.out.println("impossible");
        }
    }

    private static void makeNum(int idx,int left){
        if (idx==6){
            if(left==0){
                if (check[0]*10+check[1]+check[2]*10+check[3] == check[4]*10+check[5] ){
                    flag=true;
                    arr[0]=check[0];
                    arr[1]=check[1];
                    arr[2]=check[2];
                    arr[3]=check[3];
                    arr[4]=check[4];
                    arr[5]=check[5];
                }
            }
            return;
        }

        for(int i = 0;i<10;i++){
            if (map.get(i)<=left){
                check[idx] = i;
                makeNum(idx+1,left-map.get(check[idx]));
            }
        }
    }
}
