import java.io.File;

public class GetFolderSize {

    public static void main(String[] args) {

        String path = "D:\\Projects\\Fundamental-Java\\01.Advanced Java\\03.Streams and Directories\\Exercises\\resources";

        File file = new File(path);
        File[] files = file.listFiles();
        long sum = 0;

        for (File f : files) {

            if (!f.isDirectory()){
                sum+=f.length();
            }
        }

        double result = sum / 1000000.0;
        System.out.println(result + "MB");
    }
}
