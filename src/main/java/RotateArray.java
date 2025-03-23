import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] nums = new int[size];
        scanner.nextLine();
        for (int i = 0; i < size ; i++) {
            nums[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        solution(nums, k);
        System.out.println(Arrays.toString(nums));
    }

//    public static void solution(int[] nums, int k) {
//        int len = nums.length;
//        int[] copyNum = new int[len];
//        if (k % len != 0) {
//            k = k % len;
//            for (int i = 0; i < len; i++) {
//                copyNum[i] = nums[i];
//            }
//            for (int i = 0; i < k; i++) {
//                nums[i] = copyNum[i+len-k];
//            }
//            for (int i = k; i < len; i++) {
//                nums[i] = copyNum[i-k];
//            }
//        }
//    }

    public static void solution(int[] nums, int k) {
        if (k % nums.length != 0) {
            k = k % nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }
    }

    public static void reverse(int[] nums, int start, int end) {
        int left = start, right = end;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
