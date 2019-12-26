package IO.testStream;

import java.io.*;

public class TestReader {
    public static void main(String[] args) {
        File file = new File("/home/260422/usr/local/LOLFolder/LOL.txt");
        try(FileReader fr=new FileReader(file)) {
            char[] all = new char[(int)file.length()];
            fr.read(all);
            for (char b:
                 all) {
                System.out.print(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
