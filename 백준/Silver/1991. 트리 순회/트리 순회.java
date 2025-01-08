import java.io.*;
import java.util.*;

public class Main {

    public static class Node {
        String value;
        Node leftNode;
        Node rightNode;

        public Node(String value) {
            this.value = value;
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Node> tree = new HashMap<>();
        StringTokenizer st;
        for(int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            Node parentNode;

            if(tree.containsKey(parent)) {
                parentNode = tree.get(parent);
            } else {
                parentNode = new Node(parent);
                tree.put(parent, parentNode);
            }
            

            String child1 = st.nextToken();
            String child2 = st.nextToken();

            if(!child1.equals(".")) {
                Node childNode1 = new Node(child1);
                parentNode.leftNode = childNode1;
                tree.put(child1, childNode1);
            }

            if(!child2.equals(".")) {
                Node childNode2 = new Node(child2);
                parentNode.rightNode = childNode2;
                tree.put(child2, childNode2);
            }
        }

        Node root = tree.get("A");
        StringBuilder preorder = new StringBuilder();
        StringBuilder inorder = new StringBuilder();
        StringBuilder postorder = new StringBuilder();

        traversePreorder(root, preorder);
        System.out.println(preorder.toString());

        traverseInorder(root, inorder);
        System.out.println(inorder.toString());

        traversePostorder(root, postorder);
        System.out.println(postorder.toString());

    }

    public static void traversePreorder(Node node, StringBuilder sb) {
        if(node == null) {
            return;
        }
        sb.append(node.value);
        traversePreorder(node.leftNode, sb);
        traversePreorder(node.rightNode, sb);
    }

    public static void traverseInorder(Node node, StringBuilder sb) {
        if(node == null) {
            return;
        }
        traverseInorder(node.leftNode, sb);
        sb.append(node.value);
        traverseInorder(node.rightNode, sb);
    }

    public static void traversePostorder(Node node, StringBuilder sb) {
        if(node == null) {
            return;
        }
        traversePostorder(node.leftNode, sb);
        traversePostorder(node.rightNode, sb);
        sb.append(node.value);
    }
}
