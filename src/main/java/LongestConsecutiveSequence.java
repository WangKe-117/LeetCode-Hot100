import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] nums = new int[size];
        for (int i = 0; i < size ; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = solution(nums);
        System.out.println(result);
    }

    public static int solution(int[] nums) {
//  Fail:
//        if (nums == null) {
//            return 0;
//        }
//        int res = 1;
//        Map<Integer, int[]> map = new HashMap<>();
//        for (int num : nums) {
//            int[] test = {Integer.MAX_VALUE, Integer.MAX_VALUE};
//            map.put(num, test);
//            int pre = num - 1, suc = num + 1;
//            if (map.containsKey(pre)) {
//                if (map.get(pre)[1] != num){
//                    res++;
//                    map.get(pre)[1] = num;
//                    map.get(num)[0] = pre;
//                }
//            }
//            if (map.containsKey(suc)) {
//                if (map.get(suc)[0] != num ){
//                    res++;
//                    map.get(suc)[0] = num;
//                    map.get(num)[1] = suc;
//                }
//            }
//        }
//        return res;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int startNum = num;
                int length = 1;
                while (set.contains(startNum + 1)) {
                    startNum++;
                    length++;
                }
                if (length > res) {
                    res = length;
                }
            }
        }
        return res;
    }
}


