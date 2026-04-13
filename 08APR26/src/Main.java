import java.sql.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        QueueArray array = new QueueArray(5);

        array.enqueue(1);
        array.enqueue(2);
        array.enqueue(3);
        array.enqueue(4);
        array.enqueue(5);
        array.display();

        array.dequeue();
        array.display();
        array.dequeue();
        array.display();
        array.dequeue();
        array.display();
        array.dequeue();
        array.display();
        array.dequeue();
        array.display();


    }
}