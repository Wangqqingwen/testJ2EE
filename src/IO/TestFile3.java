package IO;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TestFile3 {
    public static void main(String[] args) throws IOException {
        File f = new File("/home/260422/usr/local/tomcat/apache-tomcat-9.0.30");

        // 以字符串数组的形式，返回当前文件夹下的所有文件和文件夹（不包含子文件及子文件夹）
        String[] list = f.list();
        System.out.println(Arrays.toString(list));

        // 以文件数组的形式，返回当前文件夹下的所有文件和文件夹（不包含子文件及子文件夹）
        File[] fs = f.listFiles();

        // 以字符串形式返回获取所在文件夹
        System.out.println(f.getParent());

        // 以文件形式返回获取所在文件夹
        File parentFile = f.getParentFile();
        System.out.println(parentFile.toString());

        // 创建文件夹，如果父文件夹skin不存在，创建就无效
        f.mkdir();

        // 创建文件夹，如果父文件夹skin不存在，就会创建父文件夹
        f.mkdirs();

        // 创建一个空文件,如果父文件夹skin不存在，就会抛出异常
        f.createNewFile();
        // 所以创建一个空文件之前，通常都会创建父目录
        f.getParentFile().mkdirs();

        // 列出所有的盘符c: d: e: 等等
        f.listRoots();

        // 刪除文件
        f.delete();

        // JVM结束的时候，刪除文件，常用于临时文件的删除
        f.deleteOnExit();
    }
}
