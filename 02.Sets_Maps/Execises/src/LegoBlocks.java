import java.util.Arrays;
import java.util.Scanner;

public class LegoBlocks {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        boolean isFitted = true;
        int[][] firstBlock = new int[rows][];
        for (int i = 0; i < rows; i++) {
            firstBlock[i] = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] secondBlock = new int[rows][];
        for (int i = 0; i < rows; i++) {
            secondBlock[i] = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        reverseArray(secondBlock);

        int size = firstBlock[0].length + secondBlock[0].length;
        for (int i = 1; i < rows; i++) {

            if (firstBlock[i].length + secondBlock[i].length != size) {
                isFitted = false;
                break;
            }
        }

        if (isFitted){
            getMatrix(firstBlock,secondBlock,size,rows);
        }else {
            getCountOfCells(firstBlock,secondBlock);
        }
    }

    private static void getCountOfCells(int[][] firstBlock, int[][] secondBlock) {

        int count = 0;
        for (int i = 0; i < firstBlock.length; i++) {

            count+=firstBlock[i].length;
        }

        for (int i = 0; i < secondBlock.length; i++) {

            count+=secondBlock[i].length;
        }

        System.out.println("The total number of cells is: " + count);
    }

    private static void getMatrix(int[][] firstBlock, int[][] secondBlock, int size, int rows) {

        int[][] matrix = new int[rows][size];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < size; j++) {

                if (j < firstBlock[i].length){
                    matrix[i][j]=firstBlock[i][j];
                }else {
                    matrix[i][j]=secondBlock[i][j-firstBlock[i].length];
                }

            }

        }

        for (int i = 0; i < rows; i++) {
            System.out.print("[");
            for (int j = 0; j < size; j++) {
                if (j < size - 1){
                    System.out.print(matrix[i][j] + ", ");
                }else {
                    System.out.print(matrix[i][j]);
                }
            }

            System.out.print("]");
            System.out.println();
        }
    }

    private static void reverseArray(int[][] secondBlock) {

        for (int i = 0; i < secondBlock.length; i++) {

            int[] current = new int[secondBlock[i].length];
            System.arraycopy(secondBlock[i], 0, current, 0, secondBlock[i].length);

            for (int j = current.length - 1, k = 0; j >= 0; j--, k++) {

                secondBlock[i][k] = current[j];
            }
        }
    }
}
