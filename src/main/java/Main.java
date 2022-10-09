import java.io.*;

/**
 * Created by Mihran Galstyan
 * All rights reserved
 */
public class Main {
    public static void main(final String[] args) {
        // Creating new folder
        File file = new File("NewFolder");
        file.mkdir();

        // Creating text file
        File txtFile = new File("NewFolder/textFile.txt");
        try {
            txtFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(txtFile, "rw")) {
            randomAccessFile.seek(15);
            randomAccessFile.writeBytes("**************");
            randomAccessFile.seek(20);

            byte[] array = new byte[8192];
            randomAccessFile.read(array);
            System.out.println(new String(array));

            randomAccessFile.seek(0);
            randomAccessFile.read(array);
            System.out.println(new String(array));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
