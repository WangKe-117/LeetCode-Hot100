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

    public static void solution(int[] nums, int k) {
        int len = nums.length;
        int[] copyNum = new int[len];
        if (k % len != 0) {
            k = k % len;
            for (int i = 0; i < len; i++) {
                copyNum[i] = nums[i];
            }
            for (int i = 0; i < k; i++) {
                nums[i] = copyNum[i+len-k];
            }
            for (int i = k; i < len; i++) {
                nums[i] = copyNum[i-k];
            }
        }
    }
}
