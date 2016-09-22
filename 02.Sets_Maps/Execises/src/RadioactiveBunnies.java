import java.util.Arrays;
import java.util.Scanner;

public class RadioactiveBunnies {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dim = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dim[0];
        int cols = dim[1];
        char[][] lair = new char[rows][];
        int playerRow = 0;
        int playerCol = 0;
        boolean isPlayerEscaped = false;
        boolean isPlayerDeath = false;

        for (int i = 0; i < rows; i++) {

            String input = scanner.nextLine();

            if (input.contains("P")) {
                playerRow = i;
                playerCol = input.indexOf("P");
                input = input.replace('P','.');
            }

            lair[i] = input.toCharArray();

        }

        String commands = scanner.nextLine();

        for (int i = 0; i < commands.length(); i++) {

            char currentDir = commands.charAt(i);
            switch (currentDir) {
                case 'U':
                    if (playerRow - 1 < 0) {
                        isPlayerEscaped = true;
                    } else {
                        playerRow += -1;
                    }
                    break;
                case 'D':
                    if (playerRow + 1 >= rows) {
                        isPlayerEscaped = true;
                    } else {
                        playerRow += 1;
                    }
                    break;
                case 'L':
                    if (playerCol - 1 < 0) {
                        isPlayerEscaped = true;
                    } else {
                        playerCol += -1;
                    }
                    break;
                case 'R':
                    if (playerCol + 1 >= cols) {
                        isPlayerEscaped = true;
                    } else {
                        playerCol += 1;
                    }
                    break;
            }

            if (lair[playerRow][playerCol] == 'B'){
                isPlayerDeath = true;
            }

            lair = spreadBunnies(lair,rows,cols);

            if (lair[playerRow][playerCol] == 'B'){
                isPlayerDeath = true;
            }

            if (isPlayerEscaped || isPlayerDeath){
                break;
            }

        }

        printMatrix(lair);

        if (isPlayerEscaped){
            System.out.printf("won: %d %d",playerRow,playerCol);
        }else {
            System.out.printf("dead: %d %d",playerRow,playerCol);
        }
    }

    private static void printMatrix(char[][] lair) {

        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[i].length; j++) {
                System.out.print(lair[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] spreadBunnies(char[][] lair, int rows, int cols) {

        char[][] newLair = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(lair[i],0,newLair[i],0,cols);
        }

        for (int i = 0; i < lair.length; i++) {

            for (int j = 0; j < lair[i].length; j++) {

                if (lair[i][j] == 'B'){
                    if (i>0){
                        newLair[i-1][j]='B';
                    }
                    if (i < lair.length-1){
                        newLair[i+1][j]='B';
                    }
                    if (j>0){
                        newLair[i][j-1]='B';
                    }
                    if (j < lair[i].length-1){
                        newLair[i][j+1]='B';
                    }

                }
            }

        }

        return newLair;
    }
}
