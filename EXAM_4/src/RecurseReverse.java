import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class RecurseReverse {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>(List.of(9,0,2,1,0));
        reverse(stack);
        System.out.println(stack);
    }

    public static void reverse(Deque<Integer> stack) {
        // BASE CASE
        if (stack.isEmpty()) return;

        int insert = stack.pop();
        reverse(stack);
        insertAtBottom(stack, insert);

    }

    public static void insertAtBottom(Deque<Integer> stack, int insert) {
        stack.addLast(insert);

    }
}