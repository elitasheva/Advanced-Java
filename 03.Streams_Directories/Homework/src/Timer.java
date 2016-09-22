import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Timer {

    public static void main(String[] args) {

        String file1 = "resources/file1.txt";
        String file2 = "resources/file2.txt";

        long startFirstTime = System.nanoTime();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(file1)))) {

            String line = "";
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        long firstFileTimeEstimation = System.nanoTime() - startFirstTime;

        long startSecondTime = System.nanoTime();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(file2)))) {

            String line = "";
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        long secondFileTimeEstimation = System.nanoTime() - startSecondTime;

        if (firstFileTimeEstimation < secondFileTimeEstimation){
            System.out.println(true);
        }else {
            System.out.println(false);
        }


    }
}
