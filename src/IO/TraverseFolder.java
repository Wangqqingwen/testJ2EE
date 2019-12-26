package IO;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

//遍历文件夹
public class TraverseFolder {
    //遍历这个目录下所有的文件(不用遍历子目录)
    //找出这些文件里，最大的和最小(非0)的那个文件，打印出他们的文件名

    public static void main(String[] args) {
        File f = new File("/home/260422/usr/local/tomcat/apache-tomcat-9.0.30");

        // 以字符串数组的形式，返回当前文件夹下的所有文件和文件夹（不包含子文件及子文件夹）
        System.out.println(Arrays.toString(f.list()));

        File[] files = f.listFiles();

        //过滤掉文件夹
        ArrayList<File> endFiles = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isDirectory()) {
                endFiles.add(files[i]);
            }
        }
        System.out.println(endFiles);

        File[] files2 = new File[endFiles.size()];
        endFiles.toArray(files2);

        File maxFile = files2[0];
        File minFile = files2[0];
        for (int i = 0; i < files2.length; i++) {


            if (maxFile.length() < files2[i].length()) {
                maxFile = files2[i];
            }
            if (minFile.length() > files2[i].length()) {
                minFile = files2[i];
            }
        }
        System.out.println("最大的文件是：" + maxFile + "大小：" + maxFile.length());
        System.out.println("最小的文件是：" + minFile + "大小：" + minFile.length());
    }
}
