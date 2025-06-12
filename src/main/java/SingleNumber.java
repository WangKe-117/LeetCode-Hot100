import java.util.Scanner;

/**
 * @Description 136.只出现一次的数字
 * @Author WangKe
 * @CreateTime 2025/6/12 21:51
 */
public class SingleNumber {
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
        int res = 0;

        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}
