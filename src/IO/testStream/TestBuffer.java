package IO.testStream;

import java.io.*;

//当既有读入的字节流又有写出的字节流时：java会先对写入的文件内容进行清空，在读文件；
//因此当想要同时读写一个文件，就会失败（并且原有文件的内容也被清空掉）

public class TestBuffer {
    public static void main(String[] args) {
        File f1 = new File("/home/260422/usr/local/LOLFolder/bufferLOL.txt");
        File f2 = new File("/home/260422/usr/local/LOLFolder/bufferLOL2.txt");
        if (!f2.exists()) {
            try {
                f2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fr = new FileReader(f1);
            br = new BufferedReader(fr);
            fw = new FileWriter(f2);
            pw = new PrintWriter(fw);
            String line = null;
            while ((line=br.readLine())!=null) {
                int len = line.trim().length();
                if (len>1&&line.substring(0, 2).equals("//")) {
                    continue;
                }
                StringBuffer sb = new StringBuffer(line);
                pw.write(sb.append("\r\n").toString());
                //pw.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                br.close();
                fw.close();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
