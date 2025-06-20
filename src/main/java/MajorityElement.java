import java.util.Scanner;

/**
 * @Description 169. 多数元素
 * @Author WangKe
 * @CreateTime 2025/6/20 17:59
 */
public class MajorityElement {
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
        int count = 0;
        int res = nums[0];

        for (int num : nums) {
            if (res == num) {
                count++;
            } else if (count == 0) {
                count++;
                res = num;
            } else {
                count--;
            }
        }

        return res;
    }
}
