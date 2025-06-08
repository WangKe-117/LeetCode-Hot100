import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description 138.随机链表的复制
 * @Author WangKe
 * @CreateTime 2025/6/8 20:35
 */
public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        ListNodeWithRandomPointer head = buildLinkList(nums);

        ListNodeWithRandomPointer result = solution(head);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNodeWithRandomPointer buildLinkList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNodeWithRandomPointer head = new ListNodeWithRandomPointer(arr[0]);
        ListNodeWithRandomPointer current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNodeWithRandomPointer(arr[i]);
            current = current.next;
        }

        return head;
    } //Error

    public static ListNodeWithRandomPointer solution(ListNodeWithRandomPointer head){
        HashMap<ListNodeWithRandomPointer, ListNodeWithRandomPointer> oldMapNew = new HashMap<>();
        ListNodeWithRandomPointer cur = head;

        while (cur != null) {
            ListNodeWithRandomPointer newNode = new ListNodeWithRandomPointer(cur.val);
            oldMapNew.put(cur, newNode);
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            ListNodeWithRandomPointer newNode = oldMapNew.get(cur);
            newNode.next = oldMapNew.get(cur.next);
            newNode.random = oldMapNew.get(cur.random);
            cur = cur.next;
        }

        return oldMapNew.get(head);
    }
}
