package IO.testStream;

import java.io.*;

public class TestDateStream {
    public static void main(String[] args) {
        write();
        read();
    }

    private static void read() {
        File f =new File("/home/260422/usr/local/LOLFolder/dateLOL.txt");

        try (
                FileInputStream fis  = new FileInputStream(f);
                DataInputStream dis =new DataInputStream(fis);
        ){
            boolean b= dis.readBoolean();
            int i = dis.readInt();
            String str = dis.readUTF();

            System.out.println("读取到布尔值:"+b);
            System.out.println("读取到整数:"+i);
            System.out.println("读取到字符串:"+str);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void write() {
        File f =new File("/home/260422/usr/local/LOLFolder/dateLOL.txt");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (
                FileOutputStream fos  = new FileOutputStream(f);
                DataOutputStream dos =new DataOutputStream(fos);
        ){
            dos.writeBoolean(true);
            dos.writeInt(300);
            dos.writeUTF("123 this is gareen");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
