import java.math.BigDecimal;
import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {

        BigDecimal playerPoints = new BigDecimal(18500);
        BigDecimal evilPoints = new BigDecimal(3_000_000);

        int playerRow = 15 / 2;
        int playerCol = 15 / 2;
        boolean isPlayerDead = false;
        boolean isEvilDead = false;
        String lastSpell = "";

        Scanner scanner = new Scanner(System.in);
        BigDecimal damageDoneToHeigan = new BigDecimal(scanner.nextLine());

        String input = scanner.nextLine();
        int countOfSpell = 0;

        while (input != null && !input.trim().equals("")) {

            int[][] initialMatrix = new int[15][15];
            evilPoints = evilPoints.subtract(damageDoneToHeigan);

            if (isDead(evilPoints)) {
                isEvilDead = true;

            }

            if (countOfSpell != 0) {
                BigDecimal damage = new BigDecimal("3500");
                playerPoints = playerPoints.subtract(damage);
                countOfSpell--;

                if (isDead(playerPoints)) {
                    isPlayerDead = true;
                    lastSpell = "Plague Cloud";

                }
            }

            if (isPlayerDead || isEvilDead){
                break;
            }

            String[] data = input.split(" ");
            String typeOfSpell = data[0];
            int hitedRow = Integer.parseInt(data[1]);
            int hitedCol = Integer.parseInt(data[2]);

            damageCells(hitedRow, hitedCol, initialMatrix);

            if (initialMatrix[playerRow][playerCol] == -1) {

                if (playerRow - 1 >= 0 && initialMatrix[playerRow - 1][playerCol] != -1) {
                    playerRow -= 1;
                } else if (playerCol + 1 <= 14 && initialMatrix[playerRow][playerCol + 1] != -1) {
                    playerCol += 1;
                } else if (playerRow + 1 <= 14 && initialMatrix[playerRow + 1][playerCol] != -1) {
                    playerRow += 1;
                } else if (playerCol - 1 >= 0 && initialMatrix[playerRow][playerCol - 1] != -1) {
                    playerCol -= 1;
                } else {
                    if (typeOfSpell.equals("Cloud") && !isEvilDead) {
                        countOfSpell = 2;
                        BigDecimal damage = new BigDecimal("3500");
                        playerPoints = playerPoints.subtract(damage);
                        countOfSpell--;
                        if (isDead(playerPoints)) {
                            isPlayerDead = true;
                            lastSpell = "Plague Cloud";

                        }

                    }
                    if (typeOfSpell.equals("Eruption") && !isEvilDead) {
                        BigDecimal damage = new BigDecimal("6000");
                        playerPoints = playerPoints.subtract(damage);
                        if (isDead(playerPoints)) {
                            isPlayerDead = true;
                            lastSpell = "Eruption";

                        }
                    }
                }

            }

            if (isPlayerDead){
                break;
            }

            input = scanner.nextLine();
        }

        if (isEvilDead)

        {
            System.out.println("Heigan: Defeated!");
        } else

        {
            System.out.printf("Heigan: %.2f\n", evilPoints);
        }

        if (isPlayerDead)

        {
            System.out.println("Player: Killed by " + lastSpell);
        } else

        {
            System.out.println("Player: " + playerPoints);
        }

        System.out.printf("Final position: %d, %d", playerRow, playerCol);

    }

    private static void damageCells(int hitedRow, int hitedCol, int[][] initialMatrix) {

        int startRow = Math.max(0, hitedRow - 1);
        int endRow = Math.min(hitedRow + 1, 14);
        int startCol = Math.max(0, hitedCol - 1);
        int endCol = Math.min(hitedCol + 1, 14);

        for (int i = startRow; i <= endRow; i++) {

            for (int j = startCol; j <= endCol; j++) {

                initialMatrix[i][j] = -1;
            }

        }
    }

    private static boolean isDead(BigDecimal points) {

        if (points.compareTo(new BigDecimal("0")) <= 0) {
            return true;
        }
        return false;
    }
}
