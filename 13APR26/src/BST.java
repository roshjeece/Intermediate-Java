public class BST {
    private Node root;

    public BST() {
        root = null;
    }

    // Public Caller that just passes the value
    public void addNode(int data) {
        root = addNode(root, data);
    }

    // Private Recursive workhorse
    private Node addNode(Node root, int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }

        if(data > root.getData())
            root.setRight(addNode(root.getRight(), data));
        else if (data < root.getData())
            root.setLeft(addNode(root.getLeft(), data));

        return root;
    }
}