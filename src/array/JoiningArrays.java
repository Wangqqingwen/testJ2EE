package array;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

//合并数组
public class JoiningArrays {
    public static void main(String[] args) {
        int arrsA[] = new int[(int)(5+Math.random()*5)];
        int arrsB[] = new int[(int)(5+Math.random()*5)];
        int arrsC[] = new int[arrsA.length+arrsB.length];
        for (int i = 0;i<arrsA.length;i++) {
            arrsA[i]= (int)(Math.random()*10);
        }
        for (int i = 0;i<arrsB.length;i++) {
            arrsB[i]= (int)(Math.random()*10);
        }
        //打印数组arrsA
        //方法1
        /*for (int arr:
             arrsB) {
            System.out.print(arr+" ");
        }*/
        //方法2：使用ArrayUtils的toString方法
        System.out.println("arrsA:"+ArrayUtils.toString(arrsA));
        //打印数组arrsB
        //方法3：使用StringUtils的join方法
        System.out.println("arrsB:{"+StringUtils.join(arrsB,',')+"}");
        System.out.println("---------");
        System.arraycopy(arrsA,0,arrsC,0,arrsA.length);
        System.arraycopy(arrsB,0,arrsC,arrsA.length,arrsB.length);
        System.out.println("arrsC:"+ArrayUtils.toString(arrsC));
    }
}
