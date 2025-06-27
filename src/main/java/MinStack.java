import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description 155. 最小栈
 * @Author WangKe
 * @CreateTime 2025/6/27 22:23
 */
public class MinStack {

    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> stack_min = new ArrayDeque<>();

    public MinStack() {

    }

    public void push(int val) {

        stack.push(val);

        int temp = val;
        if (!stack_min.isEmpty()) {
            temp = Math.min(temp, stack_min.peek());
        }

        stack_min.push(temp);

    }

    public void pop() {

        stack.pop();
        stack_min.pop();

    }

    public int top() { return stack.peek(); }

    public int getMin() { return stack_min.peek(); }

}
