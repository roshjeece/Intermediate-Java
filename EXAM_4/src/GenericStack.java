public class GenericStack<T> {

    private T[] stack;

    private int capacity;

    private int size;

    public GenericStack(int capacity) {
        this.capacity = capacity;
        size = 0;
        stack = (T[]) new Object[capacity];
    }

    public void push(T x) {
        if(size == capacity) {
            System.out.println("Stack is full");
            return;
        }
        stack[size++] = x;
    }

    public T pop() {
        T removed = stack[--size];
        stack[size] = null;
        return removed;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull(){
        return (size == capacity);
    }

    public T peek(){
        return stack[size-1];
    }
}