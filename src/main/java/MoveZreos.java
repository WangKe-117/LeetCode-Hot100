import java.util.Arrays;
import java.util.Scanner;

public class MoveZreos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] nums = new int[size];
        scanner.nextLine();
        for (int i = 0; i < size ; i++) {
            nums[i] = scanner.nextInt();
        }

        solution(nums);
        System.out.println(Arrays.toString(nums));
    }

//    public static void solution(int[] nums) {
//        int index = 0;
//        for (int num : nums) {
//            if (num != 0){
//                nums[index++] = num;
//            }
//        }
//        for (int i = index; i < nums.length; i++) {
//            nums[i] = 0;
//        }
//    }

    /**
     * Solution 2
     */
    public static void solution(int[] nums) {
        int lp = 0, rp = 0;
        for (int ignored : nums) {
            if (nums[rp] != 0) {
                int temp = nums[lp];
                nums[lp] = nums[rp];
                nums[rp] = temp;
                lp++;
            }
            rp++;
        }
    }
}
