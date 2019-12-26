package testContains.testCompator;

import java.util.*;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 下午2:09 2019/12/25
 **/
public class TestComparator {
    public static void main(String[] args) {
        //初始化
        Random r=new Random();
        List<Hero> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(new Hero("hero-"+i,r.nextInt(100),r.nextInt(100)));
        }
        //设置比较器
        Comparator<Hero> c = new Comparator<Hero>() {
            //按血量排列
            @Override
            public int compare(Hero h1, Hero h2) {
                return h1.hp>=h2.hp?1:-1;
            }
        };
        Collections.sort(list,c);
        System.out.println(list);
    }
}
