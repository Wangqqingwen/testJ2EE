package IO.testStream;

import java.io.*;

public class TestOutputStream {
    public static void main(String[] args) {

        try {
            File file = new File("/home/260422/usr/local/LOLFolder/LOL.exe");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] some = new byte[]{58,59};
            fileOutputStream.write(some);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
