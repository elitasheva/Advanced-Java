import java.util.*;
import java.util.stream.Collectors;

public class ParkingSystem {

    private static Integer matrixRows;
    private static Integer matrixCols;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> matrix = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        matrixRows = matrix.get(0);
        matrixCols = matrix.get(1);
        Set<String> occupiedSpot = new HashSet<>();

        String line = scanner.nextLine();
        while (!line.equals("stop")) {

            String[] data = line.split(" ");
            int entryRow = Integer.parseInt(data[0]);
            int currentRow = Integer.parseInt(data[1]);
            int currentCol = Integer.parseInt(data[2]);
            int count = 0;
            if (!occupiedSpot.contains(currentRow + "" + currentCol)) {

                int distance = Math.abs(entryRow - currentRow) + currentCol + 1;
                System.out.println(distance);
                occupiedSpot.add(currentRow + "" + currentCol);
            } else {

                while (true) {
                    count++;
                    int left = checkLeft(entryRow, currentRow, currentCol - count, occupiedSpot);
                    if (left > 0) {
                        System.out.println(left);
                        break;
                    }
                    int right = checkRight(entryRow, currentRow, currentCol + count, occupiedSpot);
                    if (right > 0) {
                        System.out.println(right);
                        break;
                    }

                    if (currentCol - count < 0 && currentCol + count > matrixCols) {
                        System.out.printf("Row %d full\n", currentRow);
                        break;

                    }

                }
            }

            line = scanner.nextLine();
        }

    }

    private static int checkRight(int entryRow, int currentRow, int currentCol, Set<String> occupiedSpot) {

        if (!occupiedSpot.contains(currentRow + "" + currentCol) && currentCol < matrixCols) {
            int distance = Math.abs(entryRow - currentRow) + currentCol + 1;
            occupiedSpot.add(currentRow + "" + currentCol);
            return distance;
        }
        return 0;

    }

    private static int checkLeft(int entryRow, int currentRow, int currentCol, Set<String> occupiedSpot) {

        if (!occupiedSpot.contains(currentRow + "" + currentCol) && currentCol > 0) {
            int distance = Math.abs(entryRow - currentRow) + currentCol + 1;
            occupiedSpot.add(currentRow + "" + currentCol);
            return distance;
        }
        return 0;
    }


}
