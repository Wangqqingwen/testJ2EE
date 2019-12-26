package testContains.testCompator;

import java.util.Comparator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 下午2:28 2019/12/25
 **/
public class PracticsComparator {
    public static void main(String[] args) {
        //从大到小排序
        /*Comparator<Integer> c=new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1<i2?1:-1;
            }
        };

        //拆分过程
        //1.把外壳去掉
        Comparator<Integer> c=(Integer i1,Integer i2)->{
            return i1<i2?1:-1;
        }
        //2.把return和{}去掉
        Comparator<Integer> c=(Integer i1,Integer i2)->i1<i2?1:-1;
        //3.把参数类型和圆括号去掉（只有一个参数的时候才可以去掉圆括号）
        Comparator<Integer> c=(i1,i2)->i1<i2?1:-1;
        //4.把c作为参数进行传递

        //引用静态方法来实现
        //1.使用lambda
        new TreeSet<>((i1,i2)->i1<i2?1:-1);
        //2.调用对象的方法
        new TreeSet<>((i1,i2)->PracticsComparator.compator(i1,i2));
        //3.恰好就是容器中的对象PracticsComparator的方法，
        new TreeSet<>(PracticsComparator::compator);
        */

        //Set<Integer> set = new TreeSet<>((i1,i2)->i1<i2?1:-1);
        //Set<Integer> set =new TreeSet<Integer>((i1,i2)->PracticsComparator.compator(i1,i2));
        Set<Integer> set =new TreeSet<>(PracticsComparator::compator);
        Random r=new Random();
        for (int i=0;i<10;i++){
            set.add(r.nextInt(10));
        }
        System.out.println(set);
    }

    public static int compator(Integer i1, Integer i2){
        return i1<i2?1:-1;
    }
}
