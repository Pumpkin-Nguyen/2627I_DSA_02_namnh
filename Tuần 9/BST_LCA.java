
import java.util.Arrays;
import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    Node (int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BST_LCA {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] tree = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Node root = null;
        for (int value : tree) {
            root = insert(root, value);
        }

        int[] t = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int p = t[0], q = t[1];

        System.out.println(lowest_common_ancestor(root, p, q).data);
        
    }

    static Node lowest_common_ancestor(Node root, int p, int q) {
        Node current = root;
        while (current != null) {
            if (p > current.data && q > current.data) {
                current  = current.right;
            } else if (p < current.data && q < current.data) {
                current = current.left;
            } else {
                return current;
            }
        }

        return null;
    }

    static Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
        } else if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }
}
