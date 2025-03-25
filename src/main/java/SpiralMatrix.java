import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();

        int[][] matrix = new int[row][column];
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        List<Integer> result = solution(matrix);
        System.out.println(result);
    }

    public static List<Integer> solution(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        int column = matrix[0].length;
        int up = 0, down = row - 1, left = 0, right = column - 1;
        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            up++;
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (up <= down) {
                for (int i = right; i >= left ; i--) {
                    res.add(matrix[down][i]);
                }
                down--;
            }
            if (right >= left) {
                for (int i = down; i >= up ; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}