import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb;

    private static class Node {
        int depth;
        String word;
        Node parent;
        List<Node> childList  = new ArrayList<>();

        public Node() {}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node root = new Node();
        root.childList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Node prev = root;
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                String word = st.nextToken();
                boolean In = false;
                List<Node> childList = prev.childList;
                for (Node child : childList) {
                    if (child.word.equals(word)) {
                        In = true;
                        prev = child;
                        break;
                    }
                }
                if (!In){
                    Node node = new Node();
                    node.depth = j;
                    node.word = word;
                    node.parent = prev;
                    prev.childList.add(node);
                    prev = node;
                }
            }
        }
        sb = new StringBuilder();
        findchild(root);

        System.out.println(sb);
    }

    private static void findchild(Node root) {

        List<Node> childList = root.childList;
        Collections.sort(childList , (o1, o2) -> o1.word.compareTo(o2.word));
        for (Node child : childList) {
            for (int i = 0 ; i < child.depth ; i++) {
                sb.append("--");
            }
            sb.append(child.word).append("\n");
            findchild(child);
        }
    }
}
