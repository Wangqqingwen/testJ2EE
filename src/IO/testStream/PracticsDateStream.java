package IO.testStream;

import java.io.*;

public class PracticsDateStream {
    public static void main(String[] args) {
        //第一种方式： 使用缓存流把两个数字以字符串的形式写到文件里，再用缓存流以字符串的形式读取出来，然后转换为两个数字。
        //注： 两个数字之间要有分隔符用于区分这两个数字。 比如数字是31和15，如果不使用分隔符，那么就是3115，读取出来就无法识别到底是哪两个数字。 使用分隔符31@15能解决这个问题。
        //write();
        //read();
        //
        //第二种方式： 使用数据流DataOutputStream向文件连续写入两个数字，然后用DataInpuStream连续读取两个数字
        dataWrite();
        dataRead();
    }

    private static void dataRead() {
        File f = new File("/home/260422/usr/local/LOLFolder/dateLOL.txt");
        try (
                FileInputStream fis = new FileInputStream(f);
                DataInputStream dis = new DataInputStream(fis);
        ) {
            int n = dis.readInt();
            int m = dis.readInt();
            System.out.println(n+" "+m);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void dataWrite() {
        File f = new File("/home/260422/usr/local/LOLFolder/dateLOL.txt");
        try (
                FileOutputStream fos = new FileOutputStream(f);
                DataOutputStream dos = new DataOutputStream(fos);
        ) {
            dos.writeInt(34);
            dos.writeInt(45);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read() {
        File f = new File("/home/260422/usr/local/LOLFolder/dateLOL.txt");
        try (
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
        ) {
            String line = br.readLine();
            String[] lines = line.split("@");
            for (String l:
                 lines) {
                System.out.print(l+" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void write() {
        File f = new File("/home/260422/usr/local/LOLFolder/dateLOL.txt");
        try (
                FileWriter fw = new FileWriter(f);
                PrintWriter pw = new PrintWriter(fw);
        ) {
            pw.println("34@45");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
