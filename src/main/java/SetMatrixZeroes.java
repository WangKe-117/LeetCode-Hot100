import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetMatrixZeroes {
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

        solution(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void solution(int[][] matrix) {
        Set<Integer> rSet = new HashSet<>();
        Set<Integer> cSet = new HashSet<>();
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    rSet.add(i);
                    cSet.add(j);
                }
            }
        }
        for (int r : rSet) {
            for (int i = 0; i < column; i++) {
                matrix[r][i] = 0;
            }
        }
        for (int c : cSet) {
            for (int i = 0; i < row; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}
