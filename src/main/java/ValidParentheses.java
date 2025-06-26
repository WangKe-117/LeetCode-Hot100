import java.util.*;

/**
 * @Description 20. 有效括号
 * @Author WangKe
 * @CreateTime 2025/6/26 20:45
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        Boolean result = solution(s);
        System.out.println(result);
    }

    public static Boolean solution(String s) {
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (map.get(c) != stack.peek()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
