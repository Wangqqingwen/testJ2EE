package IO.testStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestInputStream {
    public static void main(String[] args) {

        try {
            File file = new File("/home/260422/usr/local/LOLFolder/LOL.exe");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] all = new byte[(int)file.length()];
            fileInputStream.read(all);
            for (byte b:
                 all) {
                System.out.println(b);
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
