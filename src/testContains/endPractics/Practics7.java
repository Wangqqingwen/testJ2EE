package testContains.endPractics;

import testContains.Hero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 上午9:43 2019/12/25
 **/
public class Practics7 {
    /*public static void main(String[] args) {
        //重复前面的 练习-查找内容性能比较 ，不过不使用HashMap,而是使用上个练习中自定义的MyHashMap.
        //
        //准备一个ArrayList其中存放100000(十万个)Hero对象，其名称是随机的,格式是hero-[4位随机数]
        //hero-3229
        //hero-6232
        //hero-9365
        //...
        //


        ArrayList arrayList1 = createList();
        ArrayList arrayList2 = (ArrayList) arrayList1.clone();
        //因为总数很大，所以几乎每种都有重复，把名字叫做 hero-5555的所有对象找出来
        //要求使用两种办法来寻找
        //1. 不使用MyHashMap，直接使用for循环找出来，并统计花费的时间
        onlyFor(arrayList1);

        System.out.println();
        System.out.println("========================");
        //2. 借助MyHashMap，找出结果，并统计花费的时间
        byMyHashMap(arrayList2);


    }

    private static ArrayList createList() {
        ArrayList<Hero> arrayList = new ArrayList<>();
        for (int i=0;i<100000;i++){
            arrayList.add(new Hero("hero-"+(int)(Math.random()*10000)));
        }
        return arrayList;
    }

    private static void byMyHashMap(ArrayList<Hero> arrayList) {
        MyHashMap myHashMap = new MyHashMap();

        for (Iterator iterator = arrayList.iterator();iterator.hasNext();) {
            Hero hero = (Hero) iterator.next();
            myHashMap.put(hero.getName(),hero);
        }
        int index = myHashMap.hashcode("hero-5555");

        int sum2 = 0;
        long start2 = System.currentTimeMillis();
        LinkedList<Entry> linkedList = myHashMap.values[index];
        if (linkedList.size()>0) {
            for (Iterator iterator = linkedList.iterator();iterator.hasNext();) {
                Entry entry = (Entry) iterator.next();
                if (entry.getKey().equals("hero-5555")){
                    sum2++;
                }
            }
        }
        long end2 = System.currentTimeMillis();
        System.out.printf("sum:%d,time:%d",sum2,end2-start2);
    }

    private static void onlyFor(ArrayList<Hero> arrayList) {
        int sum = 0;
        long start = System.currentTimeMillis();
        for (Iterator iterator = arrayList.iterator();iterator.hasNext();){
            Hero hero = (Hero) iterator.next();
            if (hero.getName().equals("hero-5555")) {
                sum++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.printf("sum:%d,time:%d",sum,end-start);

    }*/

    public static void main(String[] args) {
        List<Hero> hs =new ArrayList<>();
        System.out.println("初始化开始");
        for (int i = 0; i < 100000; i++) {
            Hero h = new Hero(   "hero-" + random());
            hs.add(h);
        }
        //名字作为key
        //名字相同的hero，放在一个List中，作为value
        MyHashMap heroMap =new MyHashMap();
        for (Hero h : hs) {
            List<Hero> list= (List<Hero>) heroMap.get( h.name);
            if(list==null){
                list = new ArrayList<>();
                heroMap.put(h.name, list);
            }
            list.add(h);
        }

        System.out.println("初始化结束");
        System.out.println("开始查找");
        findByIteration(hs);
        findByMap(heroMap);

    }
    private static List<Hero> findByMap(MyHashMap m) {
        long start =System.currentTimeMillis();
        List <Hero>result= (List<Hero>) m.get("hero-5555");
        long end =System.currentTimeMillis();
        System.out.printf("通过map查找，一共找到%d个英雄，耗时%d 毫秒%n",result.size(),end-start);
        return result;
    }
    private static List<Hero> findByIteration (List<Hero> hs) {
        long start =System.currentTimeMillis();
        List<Hero> result =new ArrayList<>();
        for (Hero h : hs) {
            if(h.name.equals("hero-5555")){
                result.add(h);
            }
        }
        long end =System.currentTimeMillis();
        System.out.printf("通过for查找，一共找到%d个英雄，耗时%d 毫秒%n", result.size(),end-start);
        return result;
    }
    public static int random(){
        return ((int)(Math.random()*9000)+1000);
    }
}
