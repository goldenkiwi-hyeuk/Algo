import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int gcd = findGcd(X,Y);
        int lcm = (X/gcd)*(Y/gcd)*gcd;
        int[] arr = new int[lcm+1];
        for(int i = 1 ; i<arr.length;++i){
            if(i%(lcm/X) == 0 && i%(lcm/Y) == 0){
                arr[i] = 3;
            } else if(i%(lcm/X) == 0){
                arr[i] = 1;
            } else if(i%(lcm/Y) == 0){
                arr[i] = 2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i<arr.length;++i){
            if(arr[i]!=0){
                sb.append(arr[i]);
            }
        }
        System.out.println(sb.toString());
    }
    
    private static int findGcd(int X, int Y){
        int max = Math.max(X,Y);
        int min = Math.min(X,Y);
        while(true){
            if(max%min == 0){
                return min;
            } else {
                int temp = max;
                max = min;
                min = temp%min;
            }
        }
    }
}