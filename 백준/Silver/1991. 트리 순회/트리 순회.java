import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Node> list = new ArrayList<>();
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		char data1 = st.nextToken().charAt(0);
		char data2 = st.nextToken().charAt(0);
		char data3 = st.nextToken().charAt(0);
		Node root = new Node(data1);
		Node left = new Node(data2);
		Node right = new Node(data3);
		root.left = left;
		root.right = right;
		list.add(root);
		list.add(left);
		list.add(right);
		for (int i = 1; i < N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			data1 = st.nextToken().charAt(0);
			data2 = st.nextToken().charAt(0);
			data3 = st.nextToken().charAt(0);
			for(int j = 0; j < list.size(); j++) {
				if(list.get(j).data == data1) {
					Node node2 = new Node(data2);
					Node node3 = new Node(data3);
					list.get(j).left = node2;
					list.get(j).right = node3;
					list.add(node2);
					list.add(node3);
				}
			}
		}
		VLR(root);
		System.out.println(sb);
		sb = new StringBuilder();
		LVR(root);
		System.out.println(sb);
		sb = new StringBuilder();
		LRV(root);
		System.out.println(sb);
	}
	public static void VLR(Node node){
		if(node == null || node.data == '.'){
			return;
		}
		sb.append(node.data);
		VLR(node.left);
		VLR(node.right);
	}


	public static void LVR(Node node){
		if(node == null ||node.data == '.'){
			return;
		}
		LVR(node.left);
		sb.append(node.data);
		LVR(node.right);
	}


	public static void LRV(Node node){
		if(node == null ||node.data == '.'){
			return;
		}
		LRV(node.left);
		LRV(node.right);
		sb.append(node.data);
	}

}
class Node{
	char data;
	Node left,right;

	public Node(char data){
		this.data = data;
	}
}
