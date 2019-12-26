package IO.testStream;

import java.io.*;

public class PracticsBuffer {
    public static void main(String[] args) {
        File f = new File("/home/260422/usr/local/LOLFolder/LOL.txt");
        // 创建文件字符流
        // 缓存流必须建立在一个存在的流的基础上
        try (
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
        )
        {
            while (true) {
                // 一次读一行
                String line = br.readLine();
                if (null == line)
                    break;
                System.out.println(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 向文件中写入三行语句
        File f2 = new File("/home/260422/usr/local/LOLFolder/bufferLOL.txt");
        if (!f2.exists()) {
            try {
                f2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (
                // 创建文件字符流
                FileWriter fw = new FileWriter(f2);
                // 缓存流必须建立在一个存在的流的基础上
                PrintWriter pw = new PrintWriter(fw);
        ) {
            pw.println("File f = new File(\"d:/LOLFolder/LOL.exe\");\n" +
                    "System.out.println(\"当前文件是：\" +f);\n" +
                    "//文件是否存在\n" +
                    "System.out.println(\"判断是否存在：\"+f.exists());\n" +
                    "//是否是文件夹\n" +
                    "System.out.println(\"判断是否是文件夹：\"+f.isDirectory());");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
