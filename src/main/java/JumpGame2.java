import java.util.Scanner;

/**
 * @Description 跳跃游戏Ⅱ
 * @Author WangKe
 * @CreateTime 2025/6/11 21:51
 */
public class JumpGame2 {
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

    public static int solution(int[] nums) {
        int len = nums.length;
        int nextMax = 0, curMax = 0;
        int cnt = 0;

        for (int i = 0; i < len - 1 ; i++) {
            nextMax = Math.max(i + nums[i], nextMax);
            if (i == curMax) {
                cnt ++;
                if (nextMax >= len - 1) {
                    return cnt;
                }
                curMax = nextMax;
            }
        }
        return cnt;
    }
}
