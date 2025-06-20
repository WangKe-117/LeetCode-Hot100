import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description 75. 颜色分类
 * @Author WangKe
 * @CreateTime 2025/6/20 18:41
 */
public class SortColors {
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

    public static void solution(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;

        while (i <= right) { // 正确写法是 i <= right，这样才能处理到最后一个元素
            if (nums[i] == 0) {
                swap(nums, i, left);
                i ++;
                left ++;
                /*
                为什么可以 i++？因为：被换到当前位置的是 left 的内容；
                left < i，也就是说，换过来的这个值一定是已经处理过的（是 1 或 0）；
                所以我们可以放心跳过，直接处理下一个。
                 */
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right --;
                /*
                为什么不能 i++？因为：把一个未知元素从 right 换到了 i；
                不知道它是 0、1 还是 2；所以必须让 i 停下来，重新判断当前的值！
                 */
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
