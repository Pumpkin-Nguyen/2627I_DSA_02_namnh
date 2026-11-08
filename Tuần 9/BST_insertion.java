
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

public class BST_insertion {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        int[] tree = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Node root = null;
        for (int value : tree) {
            root = insert(root, value);
        }

        preOrder(root);
        
    }

    public static Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
        } else if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null)
            return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }
}
