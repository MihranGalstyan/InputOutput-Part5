import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * Created by Mihran Galstyan
 * All rights reserved
 */
public class TextReader {
    public static void main(final String[] args) {
        File txtFile = new File("NewFolder/textFile.txt");


        try (RandomAccessFile randomAccessFile = new RandomAccessFile(txtFile, "r")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter page number or \"exit\": ");
            String input = scanner.nextLine();

            byte[] array = new byte[3000];
            while (!input.equals("exit")) {

                int number = Integer.parseInt(input);
                System.out.printf("Page %s is displayed", number);
                System.out.println();
                randomAccessFile.seek((long) (number - 1) * array.length);
                int count = randomAccessFile.read(array);
                System.out.println(new String(array, 0, count));
                System.out.print("Please enter page number or \"exit\": ");
                input = scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
