public class Main {
    public static void main(String[] args) {

        Node a = new Node(1);

        LinkedList list = new LinkedList(a);
        list.addLast(2);
        list.addFirst(3);

        list.display();
        System.out.println("start of confirmation");

        list.removeFirst();
        list.display();
        System.out.println("confirmation");
        list.removeLast();
        list.display();

    }
}

class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class LinkedList {
    private Node head;

    public LinkedList(Node head) {
        this.head = head;
    }

    void addFirst(int data) {
        Node new_node = new Node(data);
        new_node.setNext(head);
        head = new_node;
    }

    void removeFirst() {
        if (head == null) return;
        head = head.getNext();
    }

    void addLast(int data) {
        Node new_node = new Node(data);

        if (head == null) {
            head = new_node;
        } else {
            Node last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }

            last.setNext(new_node);
        }
    }

    void removeLast() {
        if (head == null) return;
        else if (head.getNext() == null) {
            head = null;
        }
        else {
            Node pointer = head;
            Node previous = null;
            while(pointer.getNext() != null) {
                previous = pointer;
                pointer = pointer.getNext();
            }
            previous.setNext(null);
        }
    }

    boolean search(int value) {
        if (head == null) return false;
        Node pointer = head;
        while(pointer != null) {
            if(pointer.getData() == value) return true;
        pointer = pointer.getNext();

        }
        return false;
    }

    void insertAt(int index, int data) {
        Node insert = new Node(data);

        if (head == null) {
            head = insert;
        }
        else if (index == 0) {
            addFirst(data);
        }
        else {
            Node pointer = head;
            Node previous = null;
            for (int i = 0; i < index; i++) {
                if (pointer == null) return;
                previous = pointer;
                pointer = pointer.getNext();

            }
            insert.setNext(pointer);
            previous.setNext(insert);
        }

    }

    void removeAt(int index) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        else if (index == 0) removeFirst();
        else {
            Node pointer = head;
            Node previous = null;
            for (int i = 0; i < index; i++) {
                if (pointer == null) return;
                previous = pointer;
                pointer = pointer.getNext();
            }
            previous.setNext(pointer.getNext());

        }
    }

    int size() {
        if (head == null) return 0;
        Node pointer = head;
        int i = 0;
        while (pointer != null) {
            pointer = pointer.getNext();
            i++;
        }
        return i;
    }

    // this is going to be insertion sort
    void addSorted(int[] array) {
        head = new Node(array[0]);

        for (int i = 1; i < array.length; i++) {
            Node new_node = new Node(array[i]);
            if (head.getData() > new_node.getData()) addFirst(array[i]);

        }
    }

    void display() {
        if(head == null) return;

        Node tempHead = head;
        while (tempHead != null) {
            System.out.println(tempHead);
            tempHead = tempHead.getNext();
        }
    }
}