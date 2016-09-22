import java.util.Arrays;
import java.util.Scanner;

public class RubikMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] matrixDimensions = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        int[][] matrix = new int[rows][cols];

        int count = 0;
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                count++;
                matrix[i][j] = count;

            }

        }

        int countCommand = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countCommand; i++) {

            String[] data = scanner.nextLine().split(" ");
            int numberForShuffle = Integer.parseInt(data[0]);
            String direction = data[1];
            int moves = Integer.parseInt(data[2]);
            if (direction.equals("up")) {

                moves = moves % rows;
                moveUp(numberForShuffle, moves, matrix, rows);

            } else if (direction.equals("down")) {

                moves = moves % rows;
                moveDown(numberForShuffle, moves, matrix, rows);

            } else if (direction.equals("right")) {

                moves = moves % cols;
                moveRight(numberForShuffle, moves, matrix, cols);

            } else {

                moves = moves % cols;
                moveLeft(numberForShuffle, moves, matrix, cols);

            }

        }

        rearrangeMatrix(matrix, rows, cols);

    }

    private static void rearrangeMatrix(int[][] matrix, int rows, int cols) {

        int count = 0;
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                count++;
                if (matrix[i][j] == count) {
                    System.out.println("No swap required");
                } else {

                    int[] values = findCellToSwap(matrix, rows, cols, count);
                    int temp = matrix[i][j];
                    matrix[i][j]=matrix[values[0]][values[1]];
                    matrix[values[0]][values[1]]=temp;
                    System.out.printf("Swap (%d, %d) with (%d, %d)\n",i,j,values[0],values[1]);

                }

            }

        }
    }

    private static int[] findCellToSwap(int[][] matrix, int rows, int cols, int count) {

        int[] values = new int[2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == count) {
                    values[0]=i;
                    values[1]=j;
                }

            }
        }
        return values;
    }

    private static void moveLeft(int numberForShuffle, int moves, int[][] matrix, int cols) {

        for (int i = 0; i < moves; i++) {

            int temp = matrix[numberForShuffle][0];
            for (int j = 0; j < cols - 1; j++) {

                matrix[numberForShuffle][j] = matrix[numberForShuffle][j + 1];

            }
            matrix[numberForShuffle][cols - 1] = temp;
        }
    }

    private static void moveRight(int numberForShuffle, int moves, int[][] matrix, int cols) {

        for (int i = 0; i < moves; i++) {

            int temp = matrix[numberForShuffle][cols - 1];
            for (int j = cols - 1; j >= 1; j--) {

                matrix[numberForShuffle][j] = matrix[numberForShuffle][j - 1];

            }
            matrix[numberForShuffle][0] = temp;
        }
    }

    private static void moveDown(int numberForShuffle, int moves, int[][] matrix, int rows) {

        for (int i = 0; i < moves; i++) {

            int temp = matrix[rows - 1][numberForShuffle];
            for (int j = rows - 1; j >= 1; j--) {

                matrix[j][numberForShuffle] = matrix[j - 1][numberForShuffle];

            }
            matrix[0][numberForShuffle] = temp;
        }
    }

    private static void moveUp(int numberForShuffle, int moves, int[][] matrix, int rows) {

        for (int i = 0; i < moves; i++) {

            int temp = matrix[0][numberForShuffle];
            for (int j = 0; j < rows - 1; j++) {

                matrix[j][numberForShuffle] = matrix[j + 1][numberForShuffle];

            }
            matrix[rows - 1][numberForShuffle] = temp;
        }
    }
}
