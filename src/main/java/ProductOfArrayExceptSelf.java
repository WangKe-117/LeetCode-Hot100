import java.util.Arrays;
import java.util.Scanner;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] nums = new int[size];
        scanner.nextLine();
        for (int i = 0; i < size ; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] result = solution(nums);
        System.out.println(Arrays.toString(result));
    }

//    public static int[] solution(int[] nums) {
//        int len = nums.length;
//        int[] res = new int[len];
//        int[] prefix = new int[len];
//        int[] suffix = new int[len];
//        prefix[0] = nums[0];
//        suffix[len - 1] = nums[len - 1];
//        for (int i = 1; i < len; i++) {
//            prefix[i] = prefix[i - 1] * nums[i];
//        }
//        for (int i = len - 2; i >= 0 ; i--) {
//            suffix[i] = suffix[i + 1] * nums[i];
//        }
//        for (int i = 1; i < len - 1; i++) {
//            res[i] = prefix[i - 1] * suffix[i + 1];
//        }
//        res[0] = suffix[1];
//        res[len - 1] = prefix[len - 2];
//        return res;
//    }

    // Space: O(1)
    public static int[] solution(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int pre = 1, suf =1;
        for (int i = 0; i < len; i++) {
            res[i] = pre;
            pre*= nums[i];
        }
        for (int i = len - 1; i >= 0; i--) {
            res[i]*= suf;
            suf*= nums[i];
        }
        return res;
    }
}
