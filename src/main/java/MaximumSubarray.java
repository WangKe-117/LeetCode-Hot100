import java.util.Scanner;

public class MaximumSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] nums = new int[size];
        for (int i = 0; i < size ; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = solution(nums);
        System.out.println(result);
    }

//    返回最大和
    public static int solution(int[] nums) {
        int res = Integer.MIN_VALUE, cur = 0;
        for (int num : nums) {
            cur += num;
            res = Math.max(res, cur);
            cur = Math.max(0, cur);
        }
        return res;
    }

}
