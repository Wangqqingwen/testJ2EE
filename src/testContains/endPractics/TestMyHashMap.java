package testContains.endPractics;

import testContains.Hero;

import java.util.HashMap;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 上午8:58 2019/12/25
 **/
public class TestMyHashMap {
    public static void main(String[] args) {

        //HashMap的实现原理：
        //put：键不能重复，否则会覆盖
        //get：先判断hashCode是否相同，然后在找到对应的数组链表，用equal比较键值对

        IHashMap iHashMap = new MyHashMap();
        iHashMap.put("Kim",new Hero("hero1"));
        iHashMap.put("Kom",new Hero("hero2"));
        iHashMap.put("Kom",new Hero("hero3"));
        System.out.println(iHashMap.get("Kom"));


    }
}
