import java.util.Scanner;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] nums = new int[size];
        for (int i = 0; i < size ; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        int result = solution(nums, target);
        System.out.println(result);
    }

    public static int solution(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
