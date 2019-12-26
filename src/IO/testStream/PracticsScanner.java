package IO.testStream;

import java.io.*;
import java.util.Scanner;

public class PracticsScanner {
    public static void main(String[] args) {
        File fi=new File("/home/260422/usr/local/LOLFolder/classmodel.java");
        File fo=new File("/home/260422/usr/local/LOLFolder/Dog.java");

        Scanner in =new Scanner(System.in);
        System.out.println("请输入类的名称");
        String className=in.nextLine();
        System.out.println("请输入属性的类型");
        String propertyType=in.nextLine();
        System.out.println("请输入属性的名称");
        String propertyName=in.nextLine();
        String uProerty=propertyName.replaceFirst(String.valueOf(propertyName.charAt(0)),String.valueOf((char)(propertyName.charAt(0)-32)));
        StringBuffer sb=new StringBuffer();
        try(FileReader fr=new FileReader(fi); BufferedReader br=new BufferedReader(fr)){
            String line;
            while((line=br.readLine())!=null){
                if (line.contains("@class@")) {
                    line = line.replace("@class@", className);
                }
                if (line.contains("@type@")) {
                    line = line.replace("@type@", propertyType);
                }
                if (line.contains("@property@")) {
                    line = line.replace("@property@", propertyName);
                }
                if (line.contains("@Uproperty@")) {
                    line = line.replace("@Uproperty@", uProerty);
                }
                sb.append(line+"\r\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        try(FileWriter fw=new FileWriter(fo); PrintWriter pw=new PrintWriter(fw)){
            if(!fo.exists()){
                fo.createNewFile();
            }
            pw.write(sb.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
