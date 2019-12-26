package IO.testStream;

import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class PractiseStream {
//文件拆分：文件输入流->buffer->文件输出流，关键点：while((n = fis.read(buffer))!=-1){……}
//文件合并：对拆分出来的各文件进行排序，然后有序写进最终要合并的文件
    public static void testDivide(){
        File file = new File("/home/260422/usr/local/LOLFolder/LOL.txt");
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[4];
            int i=0;
            int n;
            while((n=fileInputStream.read(buffer))!=-1){//读到文件末尾
                File newFile = new File("/home/260422/usr/local/LOLFolder/LOL"+i+".txt");
                //如果文件不存在，则创建
                if(!newFile.exists()){
                    newFile.createNewFile();
                    System.out.println("创建新文件"+i);
                }
                fileOutputStream = new FileOutputStream(newFile);
                fileOutputStream.write(buffer);
                fileOutputStream.flush();
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void testMerge(){
        File f = new File("/home/260422/usr/local/LOLFolder");
        //写一个过滤器，过滤出后缀名为txt
        File[] files = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                return name.endsWith(".txt");
            }
        });
        System.out.println(ArrayUtils.toString(files));
        //写一个比较方法
        Comparator<File> c = new Comparator<File>() {
            @Override
            public int compare(File file1, File file2) {
                return file1.lastModified()>file2.lastModified()?1:-1;
            }
        };
        Arrays.sort(files,c);
        File fm = new File("/home/260422/usr/local/LOLFolder/mergeLOL.txt");
        //如果文件不存在则创建
        if(!fm.exists()){
            try{
                fm.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try(FileOutputStream fo = new FileOutputStream(fm)){
            byte[] buffer = new byte[4];
            for(File file:files){
                FileInputStream fi = new FileInputStream(file);
                fi.read(buffer);
                fo.write(buffer);
                fo.flush();
                fi.close();
            }
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //testDivide();

        testMerge();
    }
}
