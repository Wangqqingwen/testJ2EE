package IO.testStream;

import java.io.*;

public class PracticsObjectStream {
    public static void main(String[] args) {
        //准备一个长度是10，类型是Hero的数组，使用10个Hero对象初始化该数组
        //
        //然后把该数组序列化到一个文件heros.lol
        //
        //接着使用ObjectInputStream 读取该文件，并转换为Hero数组，验证该数组中的内容，是否和序列化之前一样
        
        Hero[] heroes = new Hero[10];
        for (int i = 0;i<10; i++) {
            heroes[i] = new Hero();
            heroes[i].name = "hero:"+i;
        }

        File file = new File("/home/260422/usr/local/LOLFolder/herosLoL.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        try (
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ) {
            for (Hero hero:
                 heroes) {
                oos.writeObject(hero);
            }
            Hero[] heroes1 = new Hero[10];
            for (int i = 0; i<10; i++){
                Hero hero = (Hero) ois.readObject();
                System.out.println(hero.name);
                heroes1[i] = hero;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
