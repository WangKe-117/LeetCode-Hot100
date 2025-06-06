import java.util.Scanner;

/**
 * 141. 环形链表
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        SinglyListNode head = buildLinkList(nums);

        int pos = scanner.nextInt();

        SinglyListNode end = head, start = head;
        while (end.next != null) {
            end = end.next;
        }
        for (int i = 0; i < pos; i++) {
            start = start.next;
        }
        if (pos > 0) {
            end.next = start; //构建环形链表
        }

        boolean result = solution(head);
        System.out.println(result);
    }

    public static SinglyListNode buildLinkList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        SinglyListNode head = new SinglyListNode(arr[0]);
        SinglyListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new SinglyListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    public static boolean solution(SinglyListNode head) {
        SinglyListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
