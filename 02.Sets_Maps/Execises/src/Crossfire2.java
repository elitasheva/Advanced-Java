import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Crossfire2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] dim = Arrays.stream(scanner.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dim[0];
        int cols = dim[1];
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        int count = 1;
        for (int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {

                matrix.get(i).add(count);
                count++;
            }
        }

        String input = scanner.nextLine();
        while (!"Nuke it from orbit".equals(input)) {

            int[] data = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int currentRow = data[0];
            int currentCol = data[1];
            int radius = data[2];


            for (int i = currentRow - radius; i <= currentRow + radius; i++) {

                if (isInMatrix(i, currentCol, matrix)) {
                    matrix.get(i).set(currentCol,-1);
                }
            }

            for (int i = currentCol - radius; i <= currentCol + radius; i++) {

                if (isInMatrix(currentRow, i, matrix)) {
                    matrix.get(currentRow).set(i,-1);
                }
            }

            convertMatrixx(matrix);

            input = scanner.nextLine();
        }

        printMatrix(matrix);

    }

    private static boolean isInMatrix(int row, int col, ArrayList<ArrayList<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void convertMatrixx(ArrayList<ArrayList<Integer>> matrix) {

        for (int i = 0; i < matrix.size(); i++) {
            matrix.get(i).removeAll(Arrays.asList((new Integer[] {-1})));
        }
        matrix.removeAll(Arrays.asList(new ArrayList<Integer>()));
    }


    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {

        for (int i = 0; i < matrix.size(); i++) {

            String currentLine = "";
            for (int j = 0; j < matrix.get(i).size(); j++) {

                currentLine += matrix.get(i).get(j) +" ";
            }
            System.out.println(currentLine.trim());
        }
    }
}
