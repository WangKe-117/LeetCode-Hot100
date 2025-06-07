import java.util.Scanner;

/**
 * @Description 148.排序链表
 * @Author WangKe
 * @CreateTime 2025/6/7 21:19
 */
public class SortList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        SinglyListNode head = buildLinkList(nums);

        SinglyListNode result = solution(head);

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

    public static SinglyListNode solution(SinglyListNode head){  // 归并排序
        if (head == null || head.next == null) {
            return head;
        }

        SinglyListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {  //对半分链表
            slow = slow.next;
            fast = fast.next.next;
        }

        SinglyListNode first = head;
        SinglyListNode second = slow.next;
        slow.next = null;

        first = solution(first);
        second = solution(second);

        return merge(first, second);
    }

    public static SinglyListNode merge(SinglyListNode left, SinglyListNode right) {
        SinglyListNode dummy = new SinglyListNode(0);
        SinglyListNode tail = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        tail.next = (left != null) ? left : right;

        return dummy.next;
    }
}
