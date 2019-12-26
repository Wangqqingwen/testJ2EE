package testContains.testSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @program:
 * @description://tips:HashSet： 无序
 *     //LinkedHashSet： 按照插入顺序
 *     //TreeSet： 从小到大排序
 * @author: Wang.
 * @create: 上午9:22 2019/12/23
 **/
public class TestSet {
    //hashset无序，一般遍历采用迭代器或者增强型的for循环

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(9);
        set.add(3);
        set.add(1);
        set.add(5);
        set.add(6);
        System.out.println(set);
        for (Integer i:
             set) {
            System.out.println(i);
        }
        System.out.println("===================");
        for (Iterator iterator = set.iterator();iterator.hasNext();){
            System.out.println((Integer)iterator.next());
        }

    }
}
