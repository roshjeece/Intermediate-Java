public class QueueArray {

    // Implement the queue class using fixed-size array with all five methods

    private int[] queueArray;

    private int front;

    private int rear;

    private int size;

    private int capacity;

    public QueueArray(int capacity) {
        size = 0;
        this.capacity = capacity;
        queueArray = new int[capacity];
        this.front = 0;
        this.rear = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(int data) {
        if (size == capacity) {
            System.out.println("Queue is full.");
            return;
        }
        queueArray[rear] = data;
        // prevents overflow
        // whenever I advance the rear, it shifts right
        // whenever we hit capacity (% capacity), we wrap around
        rear = (rear + 1) % capacity;
        size++;
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Empty queue");
            return -1;
        }

        return queueArray[front];
    }

    public int dequeue() {
        if (size == 0) {
            System.out.println("Empty queue");
            return -1;
        }
        int data = queueArray[front];
        // same as enqueue modulo wrap around logic
        front = (front + 1) % capacity;
        size--;

        return data;
    }

    public void display() {
        if (size == 0) return;
        int temp = front;
        for (int i = 0; i < size; i++) {
            System.out.println(queueArray[temp]);
            temp = (temp + 1) % capacity;
        }
        System.out.println("-----");
    }
}
