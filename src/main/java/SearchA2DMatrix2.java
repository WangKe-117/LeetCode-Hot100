import java.util.Scanner;

public class SearchA2DMatrix2 {
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
        int target = scanner.nextInt();

        boolean result = solution(matrix, target);
        System.out.println(result);
    }

    public static boolean solution(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int r = 0, c = column - 1;
        while (r <= row - 1 && c >= 0) {
            if (matrix[r][c] > target) {
                c--;
            } else if (matrix[r][c] < target) {
                r++;
            } else {
                return true;
            }
        }
        return false;
    }
}
