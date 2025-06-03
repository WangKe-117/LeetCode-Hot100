import java.util.Scanner;

/**
 * @Description 21.合并两个有序链表
 * @Author WangKe
 * @CreateTime 2025/6/3 18:39
 */
public class MergeTwoSortedLists {
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

    public static SinglyListNode solution(SinglyListNode list1, SinglyListNode list2) {
        SinglyListNode v = new SinglyListNode(0); //设v为一个虚拟节点位于合并后的链表第一个节点前
        SinglyListNode cur = v, p = list1, q = list2;

        while (p != null && q != null) {
            if (p.val < q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }

        cur.next = p != null ? p : q;
        return v.next;
    }
}
