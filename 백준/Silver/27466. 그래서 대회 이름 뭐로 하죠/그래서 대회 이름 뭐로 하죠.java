import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int M = sc.nextInt();
        String str = sc.next();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        
        for(int i = str.length()-1; i>=0; --i){
            char c = str.charAt(i);
            if(cnt == 0){
                if(c != 'A' && c != 'E' && c != 'I' && c != 'O' && c!='U'){
                    sb.append(c);
                    ++cnt;
                }
            } else if(cnt == 1 || cnt == 2){
                if(c == 'A'){
                    sb.append(c);
                    ++cnt;
                }
            } else {
                sb.append(c);
                ++cnt;
                if(cnt == M){
                    flag = true;
                    break;
                } else if (i<M-cnt){
                    break;
                }
            }
        }
        
        if(flag){
            System.out.println("YES");
            System.out.println(sb.reverse());    
        } else {
            System.out.println("NO");
        }
    }
}