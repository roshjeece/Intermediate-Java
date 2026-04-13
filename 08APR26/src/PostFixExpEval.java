import java.util.ArrayDeque;
import java.util.Deque;

public class PostFixExpEval {
    public static void main(String[] args) {
        // push all numbers automatically
        // whenever read an operator, pop twice and do math with that operator, push result back


    }

    public int evaluator(String expression) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++){
            char current = expression.charAt(i);
            if (Character.isDigit(current)) {
                stack.push(current - '0');
            }
            else {
                int right = stack.pop();
                int left = stack.pop();
                int result = switch (current) {
                    case '+' -> left + right;
                    case '-' -> left - right;
                    case '*' -> left * right;
                    case '/' -> left / right;
                    default -> throw new IllegalStateException("Unexpected value: " + current);
                };
                stack.push(result);
            }
        }
        return stack.peek();
    }
}


