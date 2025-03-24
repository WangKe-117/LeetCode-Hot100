import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        List<List<Integer>> result = solution(nums);
        System.out.println(result);
    }

//三元组顺序不重要
//所以可以自己规定i < j < k
//不能包含重复三元组
    public static List<List<Integer>> solution(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length - 2; i++) {
            int x = nums[i];
            if (x + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            if (x + nums[length - 1] + nums[length - 2] < 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lp = i + 1, rp = length - 1;
            while (lp < rp) {
                if (x + nums[lp] + nums[rp] < 0) {
                    lp++;
                } else if (x + nums[lp] + nums[rp] > 0) {
                    rp--;
                } else {
                    List<Integer> ans = Arrays.asList(x, nums[lp], nums[rp]);
                    result.add(ans);
                    lp++;
                    while (lp < rp && nums[lp] == nums[lp - 1]){
                        lp++;
                    }
                    rp--;
                    while (lp < rp && nums[rp] == nums[rp + 1]){
                        rp--;
                    }
                }
            }
        }
        return result;
    }
}

// FAIL:
//    public static List<List<Integer>> solution(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            int target = -nums[i];
//            int[] check = new int[]{-1, -1};
//            if (Arrays.equals(twoSum(nums, target, i), check)) {
//                continue;
//            }
//        }
//
//    }
//
//    public static int[] twoSum(int[] nums, int target, int index) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int diff = target - nums[i];
//            if (map.containsKey(diff)) {
//                int r2 = map.get(diff);
//                if (i != index && r2 != index){
//                    return new int[]{i, r2};
//                }
//            }
//            map.put(nums[i], i);
//        }
//        return new int[]{-1, -1};
//    }
//}

