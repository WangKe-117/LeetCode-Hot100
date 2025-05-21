import java.util.Scanner;

public class IntersectionOfTwoLinkedLists {
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
    }  //Error

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

    public static SinglyListNode solution(SinglyListNode headA, SinglyListNode headB) {
        SinglyListNode p = headA, q = headB;
        while(p != q) {
            p = p!= null ? p.next : headB;
            q = q!= null ? q.next : headA;
        }
        return p;
    }
}
