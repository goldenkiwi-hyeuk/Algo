import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int numerator = a*d+b*c;
        int denominator = b*d;
        int gcd = findGcd(numerator, denominator);
        System.out.println(numerator/gcd+" "+denominator/gcd);
    }
    
    private static int findGcd(int num1, int num2){
        int max = Math.max(num1,num2);
        int min = Math.min(num1,num2);
        if(max%min == 0){
            return min;
        } else {
            return findGcd(max%min, min);
        }
    }
}