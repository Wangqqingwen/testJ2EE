package testContains;

import java.util.ArrayList;

public class TestList {
    //tips:reverse 使List中的数据发生翻转
    //shuffle 混淆List中数据的顺序
    //sort 对List中的数据进行排序
    //swap 交换两个数据的位置Collections.swap(arraylist,0,5);
    //rotate 把List中的数据，向右滚动指定单位的长度
    //synchronizedList 把非线程安全的List转换为线程安全的List。
    public static void main(String[] args) {
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        for (int i= 0; i<5; i++){
            Hero hero = new Hero("hero"+i);
            heroes.add(hero);
        }
        //方法一：
        /*for (int i=0;i<heroes.size();i++){
            if (heroes.get(i).getName().equals("hero1")){
                System.out.println("找到了name是hero1对象，在下标位置为："+i );

        }*/

        //方法二：
        Hero[] heroes1 = heroes.toArray(new Hero[]{});
        for (int i=0;i<heroes1.length;i++) {
            if (heroes1[i].getName().equals("hero1")){
                System.out.println("找到了name是hero1对象，在下标位置为："+i );
            }

        }
    }
}

