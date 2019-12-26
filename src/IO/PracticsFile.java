package IO;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * @program:
 * @description:最为重要的是思路
 * @author: Wang.
 * @create: 上午9:44 2019/12/26
 **/
public class PracticsFile {
    //要求遍历子文件夹//要用到循环遍历(递归)
    //找出这些文件里，最大的和最小(非0)的那个文件，打印出他们的文件名
    //最小的文件不能是0长度
    public static void main(String[] args) {
        File f = new File("/home/260422/usr/local/tomcat/apache-tomcat-9.0.30");

        // 以字符串数组的形式，返回当前文件夹下的所有文件和文件夹（不包含子文件及子文件夹）
        System.out.println(Arrays.toString(f.list()));

        File[] files = f.listFiles();

        ArrayList<File> endFiles = new ArrayList<>();
        //过滤掉文件夹
        File[] files2 = diveDirectorys(files, endFiles);

        //查看最大最小文件
        findMaxAndMin(files2);

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

    private static void findMaxAndMin(File[] files2) {
        File maxFile = files2[0];
        File minFile = files2[0];
        for (int i = 0; i < files2.length; i++) {

            if (maxFile.length() < files2[i].length()) {
                maxFile = files2[i];
            }
            if (minFile.length() > files2[i].length()) {
                if (files2[i].length() > 0) {
                    minFile = files2[i];
                }
            }
        }
        System.out.println("最大的文件是：" + maxFile + "大小：" + maxFile.length());
        System.out.println("最小的文件是：" + minFile + "大小：" + minFile.length());
    }

}
