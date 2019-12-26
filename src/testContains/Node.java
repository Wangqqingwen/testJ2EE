package testContains;

import java.util.ArrayList;
import java.util.List;

//二叉数
public class Node {
    public Node leftNode;
    public Node rightNode;
    public Object value;

    //插入数据
    public void add(Object v) {
        //如果当前节点没有值，则把数据放到当前节点上
        if (value == null) {
            value = v;
        } else {
            //新增的值比当前值小
            if ((Integer) v - ((Integer) value) <= 0) {
                if (leftNode == null)
                    leftNode = new Node();

                leftNode.add(v);
            }
            //新增的值比当前值大
            else {
                if (rightNode == null)
                    rightNode = new Node();

                rightNode.add(v);
            }
        }

    }

    //中序遍历所有的节点
    public List<Object> values1() {
        List<Object> values1 = new ArrayList<>();
        //左节点
        if(leftNode!=null)
            values1.addAll(leftNode.values1());


        //当前节点
        values1.add(value);

        //右节点
        if (rightNode != null)
            values1.addAll(rightNode.values1());


        return values1;
    }

    //左序遍历所有的节点
    public List<Object> values2(){
        List<Object> values2 = new ArrayList<>();

        //当前节点
        values2.add(value);

        //左节点
        if (leftNode!=null){
            values2.addAll(leftNode.values2());
        }

        //右节点
        if(rightNode!=null){
            values2.addAll(rightNode.values2());
        }

        return values2;
    }


    //右序遍历所有的节点
    public List<Object> values3(){
        List<Object> values3 = new ArrayList<>();


        //左节点
        if (leftNode!=null){
            values3.addAll(leftNode.values3());
        }

        //右节点
        if(rightNode!=null){
            values3.addAll(rightNode.values3());
        }

        //当前节点
        values3.add(value);

        return values3;
    }


    public static void main(String[] args) {
        int a[] = new int[]{12, 3, 42, 1, 4, 32, 46};
        Node roots = new Node();
        for (int num :
                a) {
            roots.add(num);
        }

        System.out.println(roots.values1());
    }
}
