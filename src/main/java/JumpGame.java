import java.util.Scanner;

/**
 * @Description 55.跳跃游戏
 * @Author WangKe
 * @CreateTime 2025/6/10 22:00
 */
public class JumpGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] nums = new int[size];
        scanner.nextLine();
        for (int i = 0; i < size ; i++) {
            nums[i] = scanner.nextInt();
        }

        boolean result = solution(nums);
        System.out.println(result);
    }

    public static boolean solution(int[] nums) {
        int len = nums.length;
        int target = len - 1;

        for (int i = len - 2; i >= 0 ; i--) {
            if (i + nums[i] >= target) {
                target = i;
            }
        }
        return target == 0;
    }
}
