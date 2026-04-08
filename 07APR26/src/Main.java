public class Main {
    public static void main(String[] args) {


        MyQueueLinkedList list = new MyQueueLinkedList();

        list.enqueue(1);
        list.enqueue(2);
        list.enqueue(3);
        System.out.println("Full list: ");
        list.display();

        int removed = list.dequeue();
        list.display();
        System.out.println("Removed: " + removed);

        int peeked = list.peek();
        System.out.println(peeked);

        boolean emptyCheck = list.isEmpty();
        System.out.println(emptyCheck);

    }
}

class Node {
    private final int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{data=" + data + '}';
    }

    public int getData() { return data; }
    public Node getNext() { return next; }
    public void setNext(Node next) { this.next = next; }
}

