import java.util.Scanner;

/**
 * @Description 287. 寻找重复数
 * @Author WangKe
 * @CreateTime 2025/6/21 20:58
 */
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] nums = new int[size];
        scanner.nextLine();
        for (int i = 0; i < size ; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = solution(nums);
        System.out.println(result);
    }

    public static int solution(int[] nums) { // 就是环形链表2
        int slow = 0, fast = 0, cur = 0;

        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];

        } while (slow != fast);

        do {
            cur = nums[cur];
            slow = nums[slow];
        } while (cur != slow);

        return slow;
    }
}
