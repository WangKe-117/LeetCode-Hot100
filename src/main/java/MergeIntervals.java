import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MergeIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[][] intervals = new int[size][2];
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < 2; j++) {
                intervals[i][j] = scanner.nextInt();
            }
        }

        int[][] result = solution(intervals);
        System.out.println(Arrays.deepToString(result));
    }

    public static int[][] solution(int[][] intervals) {
        int[][] temp = new int[intervals.length][2];
        int index = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        temp[index] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (temp[index][1] >= intervals[i][0] && temp[index][1] < intervals[i][1]) {
                temp[index][1] = intervals[i][1];
            } else if (temp[index][1] < intervals[i][0]) {
                index++;
                temp[index] = intervals[i];
            }
        }
        int[][] res = new int[index+1][2];
//        for (int i = 0; i <= index; i++) {
//            res[i] = temp[i];
//        }
        System.arraycopy(temp, 0, res, 0, index + 1);
        return res;
    }
}
