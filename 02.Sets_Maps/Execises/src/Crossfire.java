import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Crossfire {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] dim = Arrays.stream(scanner.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dim[0];
        int cols = dim[1];
        String[][] matrix = new String[rows][cols];

        int count = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                matrix[i][j] = count + "";
                count++;
            }
        }

        String input = scanner.nextLine();
        while (!"Nuke it from orbit".equals(input)) {

            int[] data = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int currentRow = data[0];
            int currentCol = data[1];
            int radius = data[2];

//            int startRow = (int) Math.max(0, currentRow - radius);
//            int endRow = (int) Math.min(currentRow + radius, rows - 1);
//            int startCol = (int) Math.max(0, currentCol - radius);
//            int endCol = (int) Math.min(currentCol + radius, cols - 1);

//            for (int i = startRow; i <= endRow; i++) {
//
//                if (currentCol < 0 || currentCol > cols - 1 || matrix[i].length <= currentCol) {
//                    continue;
//                } else {
//                    matrix[i][(int) currentCol] = "-1";
//                    //convertMatrix(matrix,i);
//                }
//
//            }

//            for (int i = startCol; i <= endCol; i++) {
//
//                if (currentRow < 0 || currentRow > rows - 1 || matrix[(int) currentRow].length <= i) {
//                    continue;
//                } else {
//                    matrix[(int) currentRow][i] = "-1";
//                    //convertMatrix(matrix,currentRow);
//                }
//
//            }

            for (int i = currentRow-radius; i <= currentRow + radius; i++) {

                if (isInMatrix(i,currentCol,matrix)){
                    matrix[i][currentCol] = "-1";
                }
            }

            for (int i = currentCol-radius; i <= currentCol + radius; i++) {

                if (isInMatrix(currentRow,i,matrix)){
                    matrix[currentRow][i] = "-1";
                }
            }

            //clearRows(matrix);
            convertMatrixx(matrix);
            //matrixPrint(matrix);

            input = scanner.nextLine();
        }

        printMatrix(matrix);

    }

    private static void clearRows(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {

            if (matrix[i][0].equals("-1")){

            }
        }
    }

    private static boolean isInMatrix(int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length  && col >= 0 && col < matrix[row].length;
    }

    private static void convertMatrixx(String[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            List<String> mat = Arrays.asList(matrix[i]).stream().filter(a -> !a.equals("-1")).collect(Collectors.toList());
            int count = mat.size();
            int b = 0;
            String[] a = new String[count];
            for (int j = 0; j < count; j++) {

                a[j] = mat.get(j);
            }
            matrix[i-b] = a;
        }
    }


    private static void matrixPrint(String[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static void printMatrix(String[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            if (matrix[i].length > 0){
                for (int j = 0; j < matrix[i].length; j++) {

                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

        }
    }
}
