import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                int r2 = map.get(diff);
                return new int[]{i, r2};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
