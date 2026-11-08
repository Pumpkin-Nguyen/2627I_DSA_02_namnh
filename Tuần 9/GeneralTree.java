
import java.util.ArrayList;
import java.util.List;

public class GeneralTree<T> {

    public static class Node<T> {

        public T data;
        public int oldestChild;
        public int nextSiblings;

        public Node(T data) {
            this.data = data;
            this.oldestChild = -1;
            this.nextSiblings = -1;
        }
    }

    private final List<Node<T>> nodes;
    private int rootIndex;

    public GeneralTree() {
        this.nodes = new ArrayList<>();
        this.rootIndex = -1;
    }

    /**
     * Create new root of tree
     * @return Index of root
     */
    public int setRoot(T data) {
        nodes.clear();
        Node<T> root = new Node<>(data);

        nodes.add(root);
        this.rootIndex = 0;
        return this.rootIndex;
    }


    /**
     * Add a child node to parent node through parentIndex
     * @return Index of new child node
     */
    public int addChild(int parentIndex, T childData) {
        if (parentIndex < 0 || parentIndex >= nodes.size()) {
            throw new IllegalArgumentException("Index of parent invalid");
        }

        Node<T> childNode = new Node<>(childData);
        nodes.add(childNode);
        int newIndex = nodes.size() - 1;
        
        Node<T> parent = nodes.get(parentIndex);

        if (parent.oldestChild == -1) {
            parent.oldestChild = newIndex;
        } else  {
            int current = parent.oldestChild;
            while (nodes.get(current).nextSiblings != -1) {
                current = nodes.get(current).nextSiblings;
            }
            nodes.get(current).nextSiblings = newIndex;
        }

        return newIndex;
    }

    /**
     * Print the tree follows pre-order
     */
    public void printPreOrder() {
        System.out.print("Pre-order: ");
        preOrder(this.rootIndex);
        System.out.println();
    }

    private void preOrder(int index) {
        if (index == -1) return;

        System.out.print(nodes.get(index).data + " ");

        preOrder(nodes.get(index).oldestChild);
        preOrder(nodes.get(index).nextSiblings);
    }

    public static void main(String[] args) {
        GeneralTree<String> tree = new GeneralTree<>();

        int a = tree.setRoot("A");
        int b = tree.addChild(a, "B");
        int c = tree.addChild(a, "C");
        int d = tree.addChild(a, "D");

        int e = tree.addChild(b, "E");
        int f = tree.addChild(b, "F");

        int g = tree.addChild(d, "G");

        tree.printPreOrder();
    }

}
