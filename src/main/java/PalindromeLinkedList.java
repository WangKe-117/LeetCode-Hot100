import java.util.Scanner;

/**
 * 234. 回文链表
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        SinglyListNode head = buildLinkList(nums);

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

    public static SinglyListNode reverseList(SinglyListNode head){
        SinglyListNode cur = head;
        SinglyListNode pre = null;
        SinglyListNode temp;

        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    public static boolean solution(SinglyListNode head){
        SinglyListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        } //找第二部分起始位置

        SinglyListNode secondHead = reverseList(slow.next);
        slow.next = null; //分离两部分

        SinglyListNode firstHead = head;
        while (secondHead != null) {
            if (firstHead.val != secondHead.val) {
                return false;
            }
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        } //对比两部分

        return true;
    }
}
