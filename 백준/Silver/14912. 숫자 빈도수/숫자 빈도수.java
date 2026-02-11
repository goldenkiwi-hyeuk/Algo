import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        char target = Character.forDigit(t,10);
        int cnt = 0;
        for(int i= 1; i<=n ; ++i){
            String str = String.valueOf(i);
            for(int j = 0; j<str.length(); ++j){
                if(str.charAt(j) == target){
                    ++cnt;
                }
            }    
        }
        System.out.println(cnt);
    }
}