import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int cnt = 0;
        for(int i = 0; i<str.length(); ++i){
            if(str.charAt(i) == 'c'){
                if(i<str.length()-1){
                    if(str.charAt(i+1) == '='){
                        ++i;
                    } else if(str.charAt(i+1) == '-'){
                        ++i;
                    }
                }
            } else if(str.charAt(i) == 'd'){
                if(i<str.length()-1 && str.charAt(i+1) == '-'){
                    ++i;
                } else if(i<str.length()-2 && str.charAt(i+1) == 'z' && str.charAt(i+2) == '='){
                    i += 2;
                }
            } else if(str.charAt(i) == 'l'){
                if(i<str.length()-1 && str.charAt(i+1) == 'j'){
                    ++i;
                }
            } else if(str.charAt(i) == 'n'){
                if(i<str.length()-1 && str.charAt(i+1) == 'j'){
                    ++i;
                }
            } else if(str.charAt(i) == 's'){
                if(i<str.length()-1 && str.charAt(i+1) == '='){
                    ++i;
                }
            } else if(str.charAt(i) == 'z'){
                if(i<str.length()-1 && str.charAt(i+1) == '='){
                    ++i;
                }
            }
            ++cnt;
        }
        System.out.println(cnt);
    }
}