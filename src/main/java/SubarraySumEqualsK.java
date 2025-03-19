import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] nums = new int[size];
        for (int i = 0; i < size ; i++) {
            nums[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        int result = solution(nums, k);
        System.out.println(result);
    }

    public static int solution(int[] nums, int k) {
        int res = 0;
        int[] prefix_sum = new int[nums.length+1];
        prefix_sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefix_sum[i] = prefix_sum[i-1] + nums[i-1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : prefix_sum) {
            int target = j - k;
            if (map.containsKey(target)) {
                res += map.get(target);
            }
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }
        return res;
    }
}
