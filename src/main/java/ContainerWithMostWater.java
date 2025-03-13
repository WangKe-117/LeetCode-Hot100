import java.util.Scanner;

public class ContainerWithMostWater {
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

    public static int solution(int[] height) {
        int maxArea = 0;
        int lp = 0, rp = height.length - 1;
        while (lp < rp) {
            int lower;
            int dis = rp - lp;
            if (height[lp] <= height[rp]) {
                lower = height[lp];
                lp++;
            }
            else {
                lower = height[rp];
                rp--;
            }
            maxArea = Math.max(maxArea, lower * dis);
        }
        return maxArea;
    }
}
