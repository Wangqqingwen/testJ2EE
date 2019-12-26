package IO;

import java.io.File;
import java.util.Date;

public class TestFile1 {
    public static void main(String[] args) {
        File file1 = new File("/home/260422/usr/local/LOLFolder");
        System.out.println("file1的绝对路径："+file1.getAbsolutePath());
        File file2 = new File("LOL.exe");
        System.out.println("file2的绝对路径："+file2.getAbsolutePath());

        File file3 = new File(file1,"LOL.exe");
        System.out.println("file3的绝对路径："+file3.getAbsolutePath());


    }
}
