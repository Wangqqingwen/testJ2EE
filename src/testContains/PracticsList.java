package testContains;

import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 上午10:33 2019/12/23
 **/
public class PracticsList {
    public static void main(String[] args) {
        //首先初始化一个List,长度是10，值是0-9。
        //然后不断的shuffle，直到前3位出现
        //3 1 4
        //
        //shuffle 1000,000 次，统计出现的概率
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        int sum =0;
        for (int i=0;i<1000000;i++){
            Collections.shuffle(list);
            String str = Integer.toString(list.get(0))+Integer.toString(list.get(1))+Integer.toString(list.get(2));

            if (str.equals("314")) {
                sum++;
            }
        }
        double i = (double)sum/1000000;
        System.out.printf("%.6f",i);
        //小数转百分比显示
        DecimalFormat df = new DecimalFormat("0.000000%");
        System.out.println(df.format(i));
    }
}
