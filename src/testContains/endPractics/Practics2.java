package testContains.endPractics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 上午11:22 2019/12/23
 **/
public class Practics2 {
    public static void main(String[] args) {
        //比较 ArrayList和LinkedList 在最后面插入100000条数据，谁快谁慢？为什么？
        List<Integer> l = null;
        System.out.println("======insertLast=======");
        l = new ArrayList<>();
        insert(l,"ArrayList");
        l = new LinkedList<>();
        insert(l,"LinkedList");

        System.out.println("======insertMid=======");
        l = new ArrayList<>();
        insertMid(l,"ArrayList");
        l = new LinkedList<>();
        insertMid(l,"LinkedList");
    }

    private static void insert(List<Integer> l, String name) {
        final int num = 5;
        for(int i=0;i<100000;i++){
            l.add(num);
        }
        //在最后面插入100000条数据
        long start = System.currentTimeMillis();
        for (int i = 0;i<100000;i++){
            l.add(num);
        }
        long end = System.currentTimeMillis();
        System.out.println (name+":"+(end-start));
    }

    private static void insertMid(List<Integer> l, String name) {
        final int num = 5;
        for(int i=0;i<100000;i++){
            l.add(num);
        }
        //在最后面插入100000条数据
        long start = System.currentTimeMillis();
        for (int i = 0;i<100000;i++){
            l.add(100000/2,num);
        }
        long end = System.currentTimeMillis();
        System.out.println (name+":"+(end-start));
    }
}
