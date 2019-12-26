package array;

import org.apache.commons.lang3.ArrayUtils;

import java.sql.SQLOutput;
import java.util.Arrays;

public class TestArrays {
    public static void main(String[] args) {
        //复制数组
        int arrsA[] = new int[]{23,31,1,3,52,22};
        int arrsB[] = Arrays.copyOfRange(arrsA,0,3);
        System.out.println(ArrayUtils.toString(arrsB));

        //转化为字符串
        System.out.println(Arrays.toString(arrsA));

        //排序
        Arrays.sort(arrsA);
        System.out.println(Arrays.toString(arrsA));

        //二分查找
        int a = Arrays.binarySearch(arrsA,31);
        System.out.println("31在数组的下标位置为："+a);

        //判断是否相等
        Boolean q = Arrays.equals(arrsA,arrsB);
        System.out.println(q);

        //数组填充
        int arrsC[] = new int[10];
        Arrays.fill(arrsC,(int)(Math.random()*10));
        System.out.println(Arrays.toString(arrsC));

        System.out.println("====================");
        //二维数组排序
        //首先定义一个5X8的二维数组，然后使用随机数填充满。
        int arrsD[][] = new int[5][8];
        for (int i=0;i<arrsD.length;i++){
            for (int j = 0;j<arrsD[i].length;j++){
                arrsD[i][j]=(int)(Math.random()*10);
            }
        }
        //打印
        for (int i=0;i<arrsD.length;i++){
            System.out.println(Arrays.toString(arrsD[i]));
        }
        System.out.println("========排序后========");
        //借助Arrays的方法对二维数组进行排序。
        sortTwoDimensionalArrays(arrsD);
        for (int i=0;i<arrsD.length;i++){
            System.out.println(Arrays.toString(arrsD[i]));
        }
    }

    public static void sortTwoDimensionalArrays(int[][] arrsD) {
        for (int i =0;i<arrsD.length;i++) {
            Arrays.sort(arrsD[i]);
        }
    }
}
