import java.util.Scanner;

/**
 * @Description 19.删除链表的倒数第 N 个节点
 * @Author WangKe
 * @CreateTime 2025/6/5 21:41
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();

        SinglyListNode head = buildLinkList(nums);

        SinglyListNode result = solution(head, n);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
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

    public static SinglyListNode solution(SinglyListNode head, int n) {
        SinglyListNode dummy = new SinglyListNode(0);
        dummy.next = head;
        SinglyListNode left = dummy, right = head;

        while (n > 0 && right != null) {
            right = right.next;
            n --;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;

        return dummy.next;
    }
}
