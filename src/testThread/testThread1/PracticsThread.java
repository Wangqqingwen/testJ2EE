package testThread.testThread1;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 上午9:35 2019/12/26
 **/
public class PracticsThread {
    //遍历所有文件，当遍历到文件是.java的时候，创建一个线程去查找这个文件的内容，
    // 不必等待这个线程结束，继续遍历下一个文件
    public static void main(String[] args) {
        File f = new File("/home/260422/usr/local/tomcat/apache-tomcat-9.0.30");

        // 以字符串数组的形式，返回当前文件夹下的所有文件和文件夹（不包含子文件及子文件夹）
        System.out.println(Arrays.toString(f.list()));

        File[] files = f.listFiles();

        ArrayList<File> endFiles = new ArrayList<>();
        //过滤掉文件夹
        File[] files2 = diveDirectorys(files, endFiles);

        for (File file :
                files2) {
            //遍历所有文件，当遍历到文件是.java的时候
            String[] split = file.toString().split("\\.");
            if (split[split.length-1].equals("java")) {
                //创建一个线程去查找这个文件的内容，
                new Thread(new FindThread(file)).start();
            }
        }
    }

    //用递归
    private static File[] diveDirectorys(File[] files, ArrayList<File> endFiles) {
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isDirectory()) {
                endFiles.add(files[i]);
            } else {
                diveDirectorys(files[i].listFiles(), endFiles);
            }
        }
        System.out.println(endFiles);
        File[] files1 = new File[endFiles.size()];
        return endFiles.toArray(files1);
    }

    static class FindThread implements Runnable{
        private File file = null;
        public FindThread() {
        }
        public FindThread(File file) {
            this.file = file;
        }
        //查找这个文件的内容，
        @Override
        public void run() {
            try(
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                ) {
                System.out.println(Thread.currentThread().getName()+"-文件名为："+file.toString());
                while (true){
                    String line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+"-"+line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //参考答案
    /*private static void findStringInfile(String folderPath, String str) {
        File dirFile = new File(folderPath);
        if (!dirFile.exists()) {
            System.out.println("[Warning] dir not exists");
            return;
        }
        if (dirFile.isFile() && dirFile.getName().endsWith(".java")) {
            new Thread() {
                public void run() {
                    try (FileReader fr = new FileReader(dirFile)) {
                        char[] cs = new char[(int)dirFile.length()];
                        fr.read(cs);
                        String fileContent = new String(cs);
                        if (fileContent.contains(str))
                            System.out.println("找到子目标字符串" + str +
                                    ", 在文件：" + dirFile.getAbsolutePath());
                        //return;
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                }
            }.start();
        } else if (dirFile.isDirectory()) {
            for (File f: dirFile.listFiles()) {
                findStringInfile(f.getAbsolutePath(), str);
            }
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("Input folder path:");
            String folderPath = s.nextLine();
            if (folderPath.equals("end"))
                return;
            System.out.println("Input String to find");
            String strToFind = s.nextLine();
            findStringInfile(folderPath, strToFind);
        }

    }
*/
}
