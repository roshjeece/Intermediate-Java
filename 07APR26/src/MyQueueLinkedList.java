public class MyQueueLinkedList {

    private Node front;

    private Node rear;

    public MyQueueLinkedList() {
        front = null;
        rear = null;
    }

    // enqueue
    void enqueue(int data) {
        Node new_node = new Node(data);
        if (rear == null) {
            rear = new_node;
            front = new_node;
        } else {
            rear.setNext(new_node);
            rear = new_node;
        }
    }

    // dequeue
    int dequeue() {
        if (front == null) {
            System.out.println("Empty queue.");
            return -1;
        } else {
            int removed = front.getData();
            front = front.getNext();
            if (front == null) rear = null;
            return removed;
        }
    }

    // peek
    public int peek() {
        if (front == null) {
            System.out.println("Empty queue.");
            return -1;
        }

        return front.getData();
    }

    // isEmpty
    public boolean isEmpty() {
        return front == null;
    }


    // display
    void display() {
        if (front == null) return;
        Node tempFront = front;
        while (tempFront != null) {
            System.out.println(tempFront);
            tempFront = tempFront.getNext();
        }
    }
}
