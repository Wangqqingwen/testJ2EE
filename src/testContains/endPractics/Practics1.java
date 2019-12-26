package testContains.endPractics;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 上午11:09 2019/12/23
 **/
public class Practics1 {
    public static void main(String[] args) {
        //生成50个 0-9999之间的随机数，要求不能有重复的\
        Set<Integer> set = new HashSet<>();

        for (int i=0;i<50;){
            int random = (int)(Math.random()*10000);
            if (set.add(random)) {
                i++;
            }
        }
        System.out.println("size:"+set.size());
        System.out.print(set+" ");
    }
}
