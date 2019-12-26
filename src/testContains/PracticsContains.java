package testContains;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class PracticsContains {
    public static void main(String[] args) {
        List<Hero> heroes = new ArrayList<>();
        for (int i= 0;i<100;i++){
            heroes.add(new Hero("hero"+i));
        }
        //创建一个容器存储不能被8整除的hero
        List<Hero> newHeros = new ArrayList<>();
        for (Hero h:
                heroes) {
            if (Integer.parseInt(h.getName().substring(4))%8!=0) {
                newHeros.add(h);
            }
        }
        Hero[] heroes1 = newHeros.toArray(new Hero[]{});
        for (Hero h1:
             heroes1) {
            System.out.println(h1.getName());
        }
    }
}
