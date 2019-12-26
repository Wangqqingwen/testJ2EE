package IO.testStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestWriter {
    public static void main(String[] args) {
        File file = new File("/home/260422/usr/local/LOLFolder/LOL.txt");
        try (FileWriter fw = new FileWriter(file,true)) {
            String info = "abcdefg";
            fw.write(info);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
