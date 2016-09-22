
import java.math.BigDecimal;
import java.util.*;


public class TruckTour {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        BigDecimal[] litri = new BigDecimal[n];
        BigDecimal[] kilometers = new BigDecimal[n];

        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("\\s+");
            litri[i] = new BigDecimal(input[0]);
            kilometers[i] = new BigDecimal(input[1]);
        }


        for (int i = 0; i < n; i++) {
            boolean pathFound = true;
            BigDecimal petrolCarrying = new BigDecimal(0);

            for (int j = 0; j < n; j++) {

                int index = (i + j) % n;
                BigDecimal currentLiters = litri[index];
                BigDecimal currentDistance = kilometers[index];

                petrolCarrying = petrolCarrying.add(currentLiters);
                petrolCarrying = petrolCarrying.subtract(currentDistance);

                if (petrolCarrying.compareTo(BigDecimal.ZERO)<0){
                    pathFound = false;
                    break;
                }
            }

            if (pathFound){
                System.out.println(i);
                return;
            }

        }


    }
}
