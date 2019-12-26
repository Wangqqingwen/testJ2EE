package testContains.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HeroNode {
    //根据上面的学习和理解，设计一个Hero二叉树，HeroNode.
    //可以向这个英雄二叉树插入不同的Hero对象，并且按照Hero的血量倒排序。
    //
    //随机生成10个Hero对象，每个Hero对象都有不同的血量值，插入这个HeroNode后，把排序结果打印出来。


    public HeroNode leftNode;
    public HeroNode rightNode;
    public HeroNode value;

    public String name;
    public int hp;

    public HeroNode() {
    }

    public HeroNode(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void add(HeroNode v) {
        List<HeroNode> values = new ArrayList<>();
        if (value == null) {
            value = v;
        } else {
            if (v.getHp() - value.getHp() >= 0) {
                if (leftNode == null) {

                    leftNode = new HeroNode();
                }
                leftNode.add(v);
            } else {
                if (rightNode == null) {

                    rightNode = new HeroNode();
                }
                rightNode.add(v);
            }
        }
    }

    //中序倒排
    public List<HeroNode> values() {
        List<HeroNode> heroes = new ArrayList<>();
        if (leftNode != null) {

            heroes.addAll(leftNode.values());
        }

        heroes.add(value);

        if (rightNode != null) {

            heroes.addAll(rightNode.values());
        }

        return heroes;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                '}'+'\n';
    }

    public static void main(String[] args) {
        HeroNode[] heroNodes = new HeroNode[10];
        for (int i = 0; i < 10; i++) {
            HeroNode heroNode = new HeroNode("hero" + i, (int) (Math.random() * 100));

            heroNodes[i] = heroNode;
        }
        for (HeroNode h :
                heroNodes) {
            System.out.println(h.toString());
        }
        System.out.println("==================");
        //加进二叉数
        HeroNode hn = new HeroNode();
        for (HeroNode hero :
                heroNodes) {
            hn.add(hero);
        }
        //中序根据血量倒排
        //System.out.println(hn.values());
        /*List<HeroNode> heroList = hn.values();
        Iterator<HeroNode> iterator = heroList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/


        /*for ( hn.values().iterator();hn.values().iterator().hasNext();) {//这种写法出错的原因在于iterator()会迭代一次
            System.out.println(hn.values().iterator().next());
        }*/

        for (Iterator<HeroNode> iterator = hn.values().iterator();iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }

}
