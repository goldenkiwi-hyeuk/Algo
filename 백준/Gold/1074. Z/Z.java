import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int num = 0;
    static int row;
    static int col;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        go(0,0,N-1);
        System.out.println(num);
    }
    
    public static void go(int r, int c, int level){
//        System.out.println("num : "+num);
//        System.out.println("r : "+r+", c : "+c+", level : "+level);
        if(level ==0){
            if((r==row)&&(c==col)){
                return;
            } else if((r==row)&&(c!=col)){
                num+=1;
            } else if((r!=row)&&(c==col)){
                num+=2;
            } else {
                num+=3;
            }
            return;
        }
        
        if((r+Math.pow(2,level)>row)&&(c+Math.pow(2,level)>col)){ // 1사분면
//            System.out.println("1사분면");
            go(r, c, level-1);
        } else if ((r+Math.pow(2,level)>row)&&(c+Math.pow(2,level)<=col)){ // 2사분면
//            System.out.println("2사분면");
            num += (int) (Math.pow(2,level)*Math.pow(2,level));
            go(r, c+(int) Math.pow(2,level), level-1);
        } else if ((r+Math.pow(2,level)<=row)&&(c+Math.pow(2,level)>col)){ // 3사분면
//            System.out.println("3사분면");
            num += (int) (Math.pow(2,level)*Math.pow(2,level)*2);
            go(r+(int) Math.pow(2,level), c, level-1);
        } else if ((r+Math.pow(2,level)<=row)&&(c+Math.pow(2,level)<=col)){ // 4사분면
//            System.out.println("4사분면");
            num += (int) (Math.pow(2,level)*Math.pow(2,level)*3);
            go(r+(int) Math.pow(2,level), c+(int) Math.pow(2,level), level-1);
        }
    }
}
