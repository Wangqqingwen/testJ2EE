package IO.testStream;

import java.io.*;
import java.nio.charset.Charset;

public class PracticsIO {
    //public static void encodeFile(File encodingFile, File encodedFile);
    //
    //在这个方法中把encodingFile的内容进行加密，然后保存到encodedFile文件中。
    //加密算法：
    //数字：
    //如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4
    //如果是9的数字，变成0
    //字母字符：
    //如果是非z字符，向右移动一个，比如d变成e, G变成H
    //如果是z，z->a, Z-A。
    //字符需要保留大小写
    //非字母字符
    //比如',&^ 保留不变，中文也保留不变
    public static void main(String[] args) {
        File encodingFile = new File("/home/260422/usr/local/LOLFolder/LOL.txt");
        File encodedFile = new File("/home/260422/usr/local/LOLFolder/newLOL.txt");
        if (!encodedFile.exists()) {
            try {
                encodedFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        encodeFile2(encodingFile, encodedFile);

        File decodingFile = new File("/home/260422/usr/local/LOLFolder/newLOL.txt");
        File decodedFile = new File("/home/260422/usr/local/LOLFolder/recoverLOL.txt");
        if (!decodedFile.exists()) {
            try {
                decodedFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //decodeFile(decodingFile, decodedFile);
    }


    //加密
    public static void encodeFile(File encodingFile, File encodedFile) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(encodingFile);

            char[] all = new char[(int) encodingFile.length()];
            fr.read(all);//将文件中的数据读取到all字符数组
            //出现问题，读取1中文的时候读多4个空格，系统计算文件大小出错
            //cbuf.length 是字符数组的长度，一个中文字符也只算一个。
            //而encodingFile.length() 是文件字节长度，中文字符算2个字节呢
            for (char c:
                 all) {
                System.out.print(c);
            }
            for (int i = 0; i < all.length; i++) {
                if (all[i]>='0'&&all[i]<'9') {
                    all[i]+=1;
                }else if (all[i]=='9') {
                    all[i] = '0';
                }else if (all[i]>='a'&&all[i]<'z') {
                    all[i] += 1;
                }else if (all[i]>='A'&&all[i]<'Z') {
                    all[i] += 1;
                }else if (all[i]=='z') {
                    all[i] = 'a';
                }else if (all[i]=='Z') {
                    all[i] = 'A';
                }
            }
            for (char c:
                    all) {
                System.out.print(c);
            }
            //修改all字符数组，写入文件
            fw = new FileWriter(encodedFile);
            fw.write(all);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //加密2(正确做法，中文不会出错)
    //依然出错，file.length()方法计算出错
    public static void encodeFile2(File encodingFile, File encodedFile) {
        //FileReader fr = null;
        FileWriter fw = null;  
        InputStreamReader isr = null;
        try {
            //fr = new FileReader(encodingFile);
            isr = new InputStreamReader(new FileInputStream(encodingFile),Charset.forName("UTF-8"));
            char[] all = new char[(int) encodingFile.length()];
            isr.read(all);
            //char[] all = new char[(int) encodingFile.length()];
            //fr.read(all);//将文件中的数据读取到all字符数组
            //出现问题，读取1中文的时候读多4个空格，系统计算文件大小出错
            //cbuf.length 是字符数组的长度，一个中文字符也只算一个。
            //而encodingFile.length() 是文件字节长度，中文字符算2个字节呢
            /*for (char c:
                    all) {
                System.out.print(c);
            }*/
            System.out.println(new String(all));
            for (int i = 0; i < all.length; i++) {
                if (all[i]>='0'&&all[i]<'9') {
                    all[i]+=1;
                }else if (all[i]=='9') {
                    all[i] = '0';
                }else if (all[i]>='a'&&all[i]<'z') {
                    all[i] += 1;
                }else if (all[i]>='A'&&all[i]<'Z') {
                    all[i] += 1;
                }else if (all[i]=='z') {
                    all[i] = 'a';
                }else if (all[i]=='Z') {
                    all[i] = 'A';
                }
            }
            for (char c:
                    all) {
                System.out.print(c);
            }

            //修改all字符数组，写入文件
            fw = new FileWriter(encodedFile);

            //用trim方法去掉后面的空格
            String all2 = new String(all).trim();
            System.out.println(all2);
            fw.write(all2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                isr.close();
               // fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void decodeFile(File decodingFile, File decodedFile){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(decodingFile);
            char[] all = new char[(int) decodingFile.length()];
            fr.read(all);//将文件中的数据读取到all字符数组
            //出现问题，读取1中文的时候读多4个空格，系统计算文件大小出错
            //cbuf.length 是字符数组的长度，一个中文字符也只算一个。
            //而encodingFile.length() 是文件字节长度，中文字符算2个字节呢
            for (char c:
                    all) {
                System.out.print(c);
            }
            for (int i = 0; i < all.length; i++) {
                if (all[i]>'0'&&all[i]<='9') {
                    all[i]-=1;
                }else if (all[i]=='0') {
                    all[i] = '9';
                }else if (all[i]>'a'&&all[i]<='z') {
                    all[i] += 1;
                }else if (all[i]>'A'&&all[i]<='Z') {
                    all[i] += 1;
                }else if (all[i]=='a') {
                    all[i] = 'z';
                }else if (all[i]=='A') {
                    all[i] = 'Z';
                }
            }
            for (char c:
                    all) {
                System.out.print(c);
            }
            //修改all字符数组，写入文件
            fw = new FileWriter(decodedFile);
            fw.write(all);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
