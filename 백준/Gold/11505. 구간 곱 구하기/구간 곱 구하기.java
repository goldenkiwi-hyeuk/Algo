import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 기본아이디어 : 세그먼트트리
    private static class Node {
        int start, end, num;
        Node left, right, parent;

        public Node(int start, int end, int num, Node left, Node right, Node parent) {
            this.start = start;
            this.end = end;
            this.num = num;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public Node(){}
    }

    static List<Node> nodeList;
    static int[] arr;
    static int mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        nodeList = new ArrayList<Node>();
        for (int i = 0; i <= 4*N; i++) {
            nodeList.add(new Node());
        }
        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        nodeInit(nodeList.get(1),null,1,1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a==1){
                nodeupdate(1,b,c);
            } else {
                sb.append(getNum(1,b,c)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int getNum(int idx,int b, int c) {
        if (nodeList.get(idx).start ==b && nodeList.get(idx).end ==c) {
            return nodeList.get(idx).num;
        } else {
            int start = nodeList.get(idx).start;
            int end = nodeList.get(idx).end;
            int mid = (start+end)/2;
            if (c<=mid){
                return getNum(idx*2,b,c);
            } else if(b>mid) {
                return getNum(idx*2+1,b,c);
            } else {
                int num1 = getNum(idx*2+1,mid+1,c);
                int num2 = getNum(idx*2,b,mid);
                return (int)(((long)num1*num2)%mod);
            }
        }
    }

    private static void nodeInit(Node node, Node parent,int idx,int start, int end) {
        if (start == end) {
            node.start = start;
            node.end = end;
            node.num = arr[start]%mod;
            node.parent = parent;
            return;
        }
        node.parent = parent;
        node.start = start;
        node.end = end;
        nodeInit(nodeList.get(idx*2), node, idx*2,start, (start+end)/2);
        node.left = nodeList.get(idx*2);
        nodeInit(nodeList.get(idx*2+1), node, idx*2+1, (start+end)/2+1, end);
        node.right = nodeList.get(idx*2+1);
        node.num = (int) (((long)(node.left.num%mod)*(node.right.num%mod))%mod);
    }

    private static void nodeupdate(int idx, int targetIdx, int num) {
        if (nodeList.get(idx).start == targetIdx && nodeList.get(idx).end == targetIdx) {
            nodeList.get(idx).num = num;
            return;
        }
        int start = nodeList.get(idx).start;
        int end = nodeList.get(idx).end;
        int mid = (start+end)/2;
        if (targetIdx>=start&&targetIdx<=mid) {
            nodeupdate(idx*2,targetIdx,num);
            nodeList.get(idx).num = (int)(((long)nodeList.get(idx*2).num * nodeList.get(idx*2+1).num)%mod);
        } else if (targetIdx>mid&&targetIdx<=end) {
            nodeupdate(idx*2+1,targetIdx,num);
            nodeList.get(idx).num = (int)(((long)nodeList.get(idx*2).num * nodeList.get(idx*2+1).num)%mod);
        }
    }
}
