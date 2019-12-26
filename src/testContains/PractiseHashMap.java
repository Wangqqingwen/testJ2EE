package testContains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PractiseHashMap {
    public static void main(String[] args) {
        //准备一个ArrayList其中存放3000000(三百万个)Hero对象，其名称是随机的,格式是hero-[4位随机数]
        //hero-3229
        //hero-6232
        //hero-9365
        //...
        //
        //因为总数很大，所以几乎每种都有重复，把名字叫做 hero-5555的所有对象找出来
        //要求使用两种办法来寻找
        //1. 不使用HashMap，直接使用for循环找出来，并统计花费的时间
        //2. 借助HashMap，找出结果，并统计花费的时间
        //用数组和ArrayList都一样的
        /*Hero[] heroes = new Hero[3000000];
        for (int i = 0; i < heroes.length; i++) {
            heroes[i] = new Hero("hero-" + (int)(Math.random() * 10000));
        }
        int sum = 0;
        int index = 0;
        long start = System.currentTimeMillis();
        for (Hero h:
             heroes) {
            if (h.getName().equals("hero-5555")) {
                sum++;
                //System.out.println(index);
            }
            index++;
        }
        long end = System.currentTimeMillis();
        System.out.println("=========================");
        System.out.println("总共有："+sum+" 花费时间："+(end-start));*/

        //用HashMap
        //TODO
        List<Hero> list = new ArrayList<>();
        for (int i= 0;i<3000000;i++){
            list.add(new Hero("hero-"+(int)(Math.random()*10000)));
        }
        long start2 = System.currentTimeMillis();
        HashMap<String,ArrayList<Hero>> hMap = new HashMap<>();
        for (Hero h : list) {
            ArrayList<Hero> hero = new ArrayList<>();
            String sname = h.getName();
            if(hMap.containsKey(sname)){
                hero = hMap.get(sname);
                hero.add(h);
            }else{
                hero.add(h);
                hMap.put(sname,hero);
            }
        }
        // 查找内容，取出heroHashMap的指定对象于新的集合中
        ArrayList<Hero> heroSearch = hMap.get("hero-5555");
        long end2 = System.currentTimeMillis();
        System.out.println("========================");
        System.out.printf("num:%d,花费时间：%d",heroSearch.size(),end2-start2);
    }
}
