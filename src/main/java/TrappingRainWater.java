import java.util.Scanner;

public class TrappingRainWater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] nums = new int[size];
        scanner.nextLine();
        for (int i = 0; i < size ; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = solution(nums);
        System.out.println(result);
    }

    //前后缀法
//    public static int solution(int[] height) {
//        int len = height.length;
//        int[] prefix = new int[len], suffix = new int[len];
//        int pre_max = 0, suf_max = 0;
//        for (int i = 0; i < len; i++) {
//            pre_max = Math.max(pre_max, height[i]);
//            prefix[i] = pre_max;
//        }
//        for (int i = len - 1; i >= 0; i--) {
//            suf_max = Math.max(suf_max, height[i]);
//            suffix[i] = suf_max;
//        }
//        int res = 0;
//        for (int i = 0; i < len; i++) {
//            int lower = Math.min(prefix[i], suffix[i]);
//            res += lower - height[i];
//        }
//        return res;
//    }

    //相向双指针法
    public static int solution(int[] height) {
        int len = height.length;
        int lp = 0, rp = len - 1, pre_max = 0, suf_max = 0, res = 0;
        while (lp <= rp) {
            pre_max = Math.max(pre_max, height[lp]);
            suf_max = Math.max(suf_max, height[rp]);
            if (pre_max < suf_max) {
                res += pre_max - height[lp];
                lp ++;
            } else {
                res += suf_max - height[rp];
                rp --;
            }
        }
        return res;
    }
}
