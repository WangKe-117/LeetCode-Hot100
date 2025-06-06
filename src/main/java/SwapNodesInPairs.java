import java.util.Scanner;

/**
 * @Description 24.两两交换链表中的节点
 * @Author WangKe
 * @CreateTime 2025/6/6 21:51
 */
public class SwapNodesInPairs {
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

    public static SinglyListNode solution(SinglyListNode head){
        SinglyListNode dummy = new SinglyListNode(0);
        dummy.next = head;
        SinglyListNode pre = dummy;
        SinglyListNode first = head;
        SinglyListNode second;

        while (first != null && first.next != null) {
            second = first.next;
            SinglyListNode suc = second.next;
            second.next = first;
            pre.next = second;
            first.next = suc;
            pre = first;
            first = first.next;
        }

        return dummy.next;
    }
}
