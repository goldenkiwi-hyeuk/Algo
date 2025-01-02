import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+'){
                if (stack.isEmpty()){
                    stack.push(c);
                } else {
                    if(stack.peek() == '('){
                        stack.push(c);
                    } else {
                        while(!stack.isEmpty()){
                            if(stack.peek() == '('){
                                break;
                            }
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                    }
                }
            } else if (c == '-'){
                if (stack.isEmpty()){
                    stack.push(c);
                } else {
                    if(stack.peek() == '('){
                        stack.push(c);
                    } else {
                        while(!stack.isEmpty()){
                            if(stack.peek() == '('){
                                break;
                            }
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                    }
                }
            } else if (c == '*'){
                if (stack.isEmpty()){
                    stack.push(c);
                } else {
                    if(stack.peek() == '('){
                        stack.push(c);
                    } else if( stack.peek() == '+' || stack.peek() == '-' ) {
                        stack.push(c);
                    } else {
                        sb.append(stack.pop());
                        stack.push(c);
                    }
                }
            } else if (c == '/'){
                if (stack.isEmpty()){
                    stack.push(c);
                } else {
                    if(stack.peek() == '('){
                        stack.push(c);
                    } else if( stack.peek() == '+' || stack.peek() == '-' ) {
                        stack.push(c);
                    } else {
                        sb.append(stack.pop());
                        stack.push(c);
                    }
                }
            } else if (c == '('){
                stack.push(c);
            } else if (c == ')'){
                while(stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                sb.append(c);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
