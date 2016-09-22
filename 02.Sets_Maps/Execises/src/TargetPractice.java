import java.util.Arrays;
import java.util.Scanner;

public class TargetPractice {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] dim = Arrays.stream(scanner.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dim[0];
        int cols = dim[1];
        String snake = scanner.nextLine();

        char[][] matrix = new char[rows][cols];
        boolean isReverse = true;
        int count = 0;
        for (int i = rows-1 ; i >=0; i--) {

            if(isReverse){
                for (int j = cols-1; j >=0 ; j--) {
                    matrix[i][j] = snake.charAt(count%snake.length());
                    count++;
                }

                isReverse = false;
            }else {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = snake.charAt(count%snake.length());
                    count++;
                }
                isReverse = true;
            }

        }

        int[] projectile = Arrays.stream(scanner.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        shootTheSnake(matrix, projectile);
        clean(matrix);

        printMatrix(matrix);
    }

    private static void clean(char[][] matrix) {

        for (int i = matrix.length - 1; i > 0 ; i--) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == ' '){
                    int count = i;
                    while (count > 0 && matrix[count][j] == ' '){
                        count--;
                    }

                    matrix[i][j] = matrix[count][j];
                    matrix[count][j]=' ';
                }
            }

        }
    }

    private static void printMatrix(char[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void shootTheSnake(char[][] matrix, int[] projectile) {

        int row = projectile[0];
        int col = projectile[1];
        int radius = projectile[2];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (((i-row)*(i-row)) + ((j-col)*(j-col)) <= radius*radius){
                    matrix[i][j] = ' ';
                }
            }

        }
    }
}
