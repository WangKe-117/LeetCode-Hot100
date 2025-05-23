import java.util.Arrays;
import java.util.Scanner;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] nums = new int[size];
        for (int i = 0; i < size ; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        int[] result = solution(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }

        int[] res = new int[2];
        int left = 0, right = len - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (nums[left] != target) {
            return new int[]{-1, -1};
        }
        res[0] = left;

        left = 0; right = len - 1;
        while(left < right) {
            int mid = left + (right - left) / 2 + 1;
            if(nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        res[1] = right;

        return res;
    }
}
