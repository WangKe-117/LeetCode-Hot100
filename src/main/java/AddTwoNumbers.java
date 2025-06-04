import java.util.Scanner;

/**
 * @Description 2.两数相加
 * @Author WangKe
 * @CreateTime 2025/6/4 21:23
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeA = scanner.nextInt();
        int[] numsA = new int[sizeA];
        for (int i = 0; i < sizeA ; i++) {
            numsA[i] = scanner.nextInt();
        }

        int sizeB = scanner.nextInt();
        int[] numsB = new int[sizeB];
        for (int i = 0; i < sizeB ; i++) {
            numsB[i] = scanner.nextInt();
        }

        SinglyListNode headA = buildLinkList(numsA);
        SinglyListNode headB = buildLinkList(numsB);

        SinglyListNode result = solution(headA, headB);
        System.out.println(result.val);
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

    public static SinglyListNode solution(SinglyListNode l1, SinglyListNode l2) {
        SinglyListNode d = new SinglyListNode(0);
        SinglyListNode cur = d;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = 0, val2 = 0;

            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            int sum = val1 + val2 + carry;
            cur.next = new SinglyListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
        }

        return d.next;
    }
}
