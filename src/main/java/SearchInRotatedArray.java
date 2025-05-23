import java.util.Scanner;

/**
 * 33. 搜索旋转排序数组
 */
public class SearchInRotatedArray {
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
            }

            if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return  -1;
    }
}
