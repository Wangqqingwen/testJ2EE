package testContains.endPractics;

import java.util.*;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 下午1:52 2019/12/23
 **/
public class Practics4 {
    public static void main(String[] args) {
        //使用如下键值对，初始化一个HashMap：
        //adc - 物理英雄
        //apc - 魔法英雄
        //t - 坦克
        //
        //对这个HashMap进行反转，key变成value,value变成key
        //提示： keySet()可以获取所有的key, values()可以获取所有的value
        Map<String,String> map = new HashMap<>();
        Map<String,String> endMap = new HashMap<>();
        map.put("adc","物理英雄");
        map.put("apc","魔法英雄");
        map.put("tank","坦克");
        Set<String> set = map.keySet();
        for (String str:
             set) {
            endMap.put(map.get(str),str);
        }
        System.out.println(map);
        System.out.println(endMap);
    }
}
