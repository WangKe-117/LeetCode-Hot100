import java.util.Scanner;

public class SearchA2DMatrix {
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
        int left = 0, right = row * column - 1;

        while (left <= right) {
            int index = (left + right) / 2;
            if (matrix[index / column][index % column] > target) {
                right = index - 1;
            } else if (matrix[index / column][index % column] < target) {
                left = index + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
